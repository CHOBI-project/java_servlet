package io.github.java_servlet.CollectionOfBooks.DeleteBook;

import io.github.java_servlet.CollectionOfBooks.DAO.BooksDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        new BooksDAO().deleteBook(id);

        response.sendRedirect("./BookListServlet");
    }
}
