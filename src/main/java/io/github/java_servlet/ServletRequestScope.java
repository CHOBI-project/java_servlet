package io.github.java_servlet;

import io.github.java_servlet.instance.Animal;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

//[Request Scope]はレスポンスが返されるまで使用可能/フォワードのみ

@WebServlet("/ServletRequestScope")
public class ServletRequestScope extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Animal cat = new Animal("たま", "猫");

        //リクエストスコープに格納
        request.setAttribute("cat", cat);

        //フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("requestScope/servletRequestScope.jsp");
        dispatcher.forward(request, response);
    }
}
