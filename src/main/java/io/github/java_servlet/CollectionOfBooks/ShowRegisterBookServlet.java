package io.github.java_servlet.CollectionOfBooks;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/ShowRegisterBookServlet")
public class ShowRegisterBookServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // CollectionOfBooks/RegisterBook.jspへ遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("CollectionOfBooks/RegisterBook.jsp");
        dispatcher.forward(request, response);
    }
}
