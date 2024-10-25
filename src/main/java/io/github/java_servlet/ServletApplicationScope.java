package io.github.java_servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServletApplicationScope", value = "/servlet-application-scope")
public class ServletApplicationScope extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User human = new User("1000", "tanaka", "biker");

        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("human", human);
    }
}
