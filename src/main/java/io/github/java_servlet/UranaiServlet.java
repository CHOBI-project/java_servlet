package io.github.java_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UranaiServlet", value = "/uranai-servlet")
public class UranaiServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] luckArray = {"超すっきり", "スッキリ", "最悪"};
        int index = (int)(Math.random() * 3);
        String value = luckArray[index];

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
        String today = formatter.format(date);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\"/>");
        out.println("<title>スッキリ占い</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>占い結果</h1>");
        out.println("<p>" + today + "の運勢は「" + value + "」です!</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
