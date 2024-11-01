package io.github.java_servlet.CollectionOfBooks;

import io.github.java_servlet.CollectionOfBooks.DAO.Book;
import io.github.java_servlet.CollectionOfBooks.DAO.BooksDAO;
import jakarta.servlet.RequestDispatcher;
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

@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringId = request.getParameter("id");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String publishDate = request.getParameter("publish-date");

        boolean hasError = false;
        if (title == null || title.isEmpty()) {
            request.setAttribute("titleError", "タイトルが入力されていません");
            hasError = true;
        }
        if (author == null || author.isEmpty()) {
            request.setAttribute("authorError", "著者が入力されていません");
            hasError = true;
        }
        if (publisher == null || publisher.isEmpty()) {
            request.setAttribute("publisherError", "出版社が入力されていません");
            hasError = true;
        }
        if (publishDate == null || publishDate.isEmpty()) {
            request.setAttribute("publishDateError", "出版日が入力されていません");
            hasError = true;
        }

        if (hasError) {
            request.setAttribute("id", stringId);
            request.setAttribute("title", title);
            request.setAttribute("author", author);
            request.setAttribute("publisher", publisher);
            request.setAttribute("publishDate", publishDate);

            RequestDispatcher dispatcher = request.getRequestDispatcher("CollectionOfBooks/EditBook.jsp");
            dispatcher.forward(request, response);
            return;
        }

        int id = 0;
        if (stringId != null && !stringId.isEmpty()) {
            id = Integer.parseInt(stringId);
        }

        Date date;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.parse(publishDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }

        Book book = new Book(id, title, author, publisher, date);
        BooksDAO booksDAO = new BooksDAO();
        booksDAO.updateBook(book);

        response.sendRedirect("./BookListServlet");
    }
}
