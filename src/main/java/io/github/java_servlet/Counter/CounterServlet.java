package io.github.java_servlet.Counter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        Integer count = 0;
        ServletContext application = config.getServletContext();
        application.setAttribute("count", count);

        System.out.println("init()が実行されました");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = this.getServletContext();
        Integer count = (Integer)application.getAttribute("count");
        count++;
        application.setAttribute("count", count);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>訪問回数表示</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>訪問回数:" + count + "</p>");
        out.println("<a href=\"CounterServlet\">更新</a>");
        out.println("</body>");
        out.println("</html>");
    }

    public void destroy() {
        System.out.println("destroy()が実行されました");
    }
}