package io.github.java_servlet;

import io.github.java_servlet.instance.RegisterUserLogic;
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

//[Session scope]はリクエストを跨いで使用可能/フォワード・リダイレクトどちらも使用可能

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwardPath = null;
        String action = request.getParameter("action");

        if (action == null) {
            forwardPath = "sessionScope/userInput.jsp";
        } else if (action.equals("done")) {
            HttpSession session = request.getSession();
            User registeredUser = (User) session.getAttribute("registeredUser");

            RegisterUserLogic logic = new RegisterUserLogic();
            logic.execute(registeredUser);
            session.removeAttribute("registeredUser");
            forwardPath = "sessionScope/registerDone.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        User registerUser = new User(id, name, pass);

        HttpSession session = request.getSession();
        session.setAttribute("registeredUser", registerUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("sessionScope/registerConfirm.jsp");
        dispatcher.forward(request, response);
    }
}