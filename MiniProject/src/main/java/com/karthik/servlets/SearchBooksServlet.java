package com.karthik.servlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "seachBooks", urlPatterns = "/searchBooks.jlc")
public class SearchBooksServlet extends HttpServlet {
public void service(HttpServletRequest request, HttpServletResponse response)
throws IOException, ServletException {
System.out.println("----SearchBooksServlet---");
// 1.Collect Input Data
String cat = request.getParameter("category");
System.out.println(cat);
// 2.Do Processing
HttpSession session = request.getSession();
session.setAttribute("CAT", cat);
//Make Empty Cart Ready
List<String> mycart1 = (List<String>) session.getAttribute("MyCart");
if (mycart1 == null) {
List<String> mycart = new ArrayList<>();
session.setAttribute("MyCart", mycart);
}
List<String> blist = new ArrayList<>();
String msg = "";
String page = "";
if (cat == null || cat.length() == 0) {
msg = "Please Select Category";
request.setAttribute("MSG", msg);
page = "index.jsp";
} else if (cat.equals("Java")) {
blist.add("Master Java8");
blist.add("Master Spring 5");
blist.add("Master Hibernate 5");
blist.add("Master Spring Boot");
blist.add("Master MicroServices");
session.setAttribute("BooksList", blist); // IMP
page = "ShowBooks.jsp";
} else if (cat.equals("Web")) {
blist.add("Learn Java Script");
blist.add("Learn Angular");
blist.add("Learn React");
blist.add("Learn Nod JS");
session.setAttribute("BooksList", blist); // IMP
page = "ShowBooks.jsp";
} else if (cat.equals("Python")) {
msg = "Sorry, No Books for " + cat;
request.setAttribute("MSG", msg);
page = "index.jsp";
}
//3.Forward
RequestDispatcher rd = request.getRequestDispatcher(page);
rd.forward(request, response);
}
}
