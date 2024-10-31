package io.github.java_servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/ServletForward")
public class ServletForward extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //フォワード(内部から内部に転送する時)
//        RequestDispatcher dispatcher = request.getRequestDispatcher("forward_redirect/servletForward.jsp");
//        dispatcher.forward(request, response);

        //レダイレクト(内部から外部に転送する時)
        response.sendRedirect("forward_redirect/servletForward.jsp");
    }
}
