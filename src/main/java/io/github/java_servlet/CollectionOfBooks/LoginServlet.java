package io.github.java_servlet.CollectionOfBooks;

import io.github.java_servlet.CollectionOfBooks.DAO.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        UserDAO userDAO = new UserDAO();

        try {
            if (userDAO.login(name, pass)) {
                request.setAttribute("name", name);
                RequestDispatcher dispatcher = request.getRequestDispatcher("CollectionOfBooks/LoginSuccess.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("CollectionOfBooks/LoginFalse.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
