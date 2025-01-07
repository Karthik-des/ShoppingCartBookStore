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

@WebServlet(name="placeOrder" , urlPatterns = "/placeOrder.jlc")
public class PlaceOrderServlet extends HttpServlet{
public void service(HttpServletRequest request, HttpServletResponse response)
throws IOException,ServletException{
System.out.println("----PlaceOrderServlet---");
//1. No Input data
//2.Do Processing
String page="placeOrder.jsp";
HttpSession session = request.getSession();
session.removeAttribute("MyCart");
List<String> mycart = new ArrayList<>();
session.setAttribute("MyCart", mycart);
//3.Forward
RequestDispatcher rd=request.getRequestDispatcher(page);
rd.forward(request, response);
}
}