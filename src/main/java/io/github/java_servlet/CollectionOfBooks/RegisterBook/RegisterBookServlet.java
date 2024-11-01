package io.github.java_servlet.CollectionOfBooks.RegisterBook;

import io.github.java_servlet.CollectionOfBooks.DAO.Book;
import io.github.java_servlet.CollectionOfBooks.DAO.BooksDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/RegisterBookServlet")
public class RegisterBookServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title =  request.getParameter("title");
        String author = request.getParameter("author");
        String publish = request.getParameter("publish");
        String publishDate = request.getParameter("publish-date");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date publishDateFormat;

        try {
            publishDateFormat = dateFormat.parse(publishDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Book book = new Book(title, author, publish, publishDateFormat);
        BooksDAO booksDAO = new BooksDAO();
        booksDAO.Registration(book);

        response.sendRedirect("CollectionOfBooks/BookList/BookList.jsp");
    }
}
