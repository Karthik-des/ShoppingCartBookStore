package com.karthik.servlets;

import com.karthik.utils.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet") // Annotation for URL mapping
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String username = (String) request.getSession().getAttribute("username");

        try (Connection conn = DBConnection.getConnection()) {
            String query = "UPDATE users SET email = ?, name = ? WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, name);
            ps.setString(3, username);
            ps.executeUpdate();
            response.getWriter().write("Profile updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
