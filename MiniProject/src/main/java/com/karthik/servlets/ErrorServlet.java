package com.karthik.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ErrorServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMessage = (String) request.getAttribute("javax.servlet.error.message");

        // Log the error
        logger.log(Level.SEVERE, "Error occurred: " + errorMessage, throwable);

        // Set a custom message (optional)
        request.setAttribute("errorMessage", "A server error occurred. Our team is working on it.");

        // Forward to the custom error page
        request.getRequestDispatcher("/error500.jsp").forward(request, response);
    }
}
