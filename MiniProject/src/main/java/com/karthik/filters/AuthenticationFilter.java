package com.karthik.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic (if needed)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Get the session object
        HttpSession session = httpRequest.getSession(false);

        // Check if the user is logged in (e.g., "username" is in the session)
        if (session == null || session.getAttribute("username") == null) {
            // Redirect to login page if not logged in
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
        } else {
            // User is logged in, continue to the requested resource
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Cleanup logic (if needed okay kkk)
    }
}
