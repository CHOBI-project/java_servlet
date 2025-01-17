package io.github.java_servlet.CollectionOfBooks;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/MainMenuServlet")
public class MainMenuServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // CollectionOfBooks/MainMenu.jspへ遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("CollectionOfBooks/MainMenu.jsp");
        dispatcher.forward(request, response);
    }
}
