package io.github.java_servlet.Dokotubu;

import io.github.java_servlet.instance.GetMutterListLogic;
import io.github.java_servlet.instance.Mutter;
import io.github.java_servlet.instance.PostMutterLogic;
import io.github.java_servlet.instance.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Main")
public class Main extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetMutterListLogic mutterListLogic = new GetMutterListLogic();
        List<Mutter> mutterList = mutterListLogic.execute();
        request.setAttribute("mutterList", mutterList);

        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect("dokotubu/dokotubu.jsp");
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("dokotubu/main.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("text");

        if (text != null && text.length() != 0) {
            HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute("loginUser");
            Mutter mutter = new Mutter(loginUser.getName(), text);

            PostMutterLogic postMutterLogic = new PostMutterLogic();
            postMutterLogic.excute(mutter);
        } else {
            request.setAttribute("errorMsg", "つぶやきが入力してされていません");
        }

        GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
        List<Mutter> mutterList = getMutterListLogic.execute();
        request.setAttribute("mutterList", mutterList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("dokotubu/main.jsp");
        requestDispatcher.forward(request, response);
    }
}
