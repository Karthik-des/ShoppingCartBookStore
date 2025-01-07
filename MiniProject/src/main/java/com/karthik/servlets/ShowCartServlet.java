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

@WebServlet(name="showMyCart", urlPatterns = "/showMyCart.jlc")
public class ShowCartServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("----ShowCartServlet---");

        // Retrieve the cart from the session
        List<String> cartList = (List<String>) request.getSession().getAttribute("MyCart");
        if (cartList == null) {
            cartList = new ArrayList<>();
        }

        // Pass cart list to JSP
        request.setAttribute("cartList", cartList);
        
        // Forward the request to the showCart.jsp page
        String page = "showCart.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }
}
