package io.github.java_servlet;

import io.github.java_servlet.instance.Animal;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ELSaveServlet")
public class ELSaveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Animal cat = new Animal("クロ", "猫");
        Animal dog = new Animal("シロ", "犬");

        request.setAttribute("cat", cat);
        request.setAttribute("dog", dog);

        RequestDispatcher dispatcher = request.getRequestDispatcher("EL/elPage.jsp");
        dispatcher.forward(request, response);
    }
}
