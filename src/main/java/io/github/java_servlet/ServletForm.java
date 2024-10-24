package io.github.java_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletForm", value = "/servlet-form")
public class ServletForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String errMsg = "";

        if (name == null || name.length() == 0) {
            errMsg += "名前が入力されていません。<br>";
        }

        if (gender == null || gender.length() == 0) {
            errMsg += "性別が選択されていません。<br>";
        } else {
            if (gender.equals("0")) {
                gender = "男性";
            } else if (gender.equals("1")) {
                gender = "女性";
            }
        }

        String msg = name + "さん(" + gender + ")を登録しました";
        if (errMsg.length() != 0) {
            msg = errMsg;
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ServletFormユーザー登録情報</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>登録情報</h1>");
        out.println("<p>" + msg + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
