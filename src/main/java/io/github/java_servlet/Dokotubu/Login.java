package io.github.java_servlet.Dokotubu;

import io.github.java_servlet.instance.LoginLogic;
import io.github.java_servlet.instance.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String password = request.getParameter("pass");
        User user = new User(name, password);

        LoginLogic logic = new LoginLogic();
        boolean isLogin = logic.excute(user);

        if (isLogin) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("dokotubu/loginResult.jsp");
        dispatcher.forward(request, response);
    }
}
