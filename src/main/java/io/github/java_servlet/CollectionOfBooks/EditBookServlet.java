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

@WebServlet("/EditBookServlet")
public class EditBookServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    // 書籍情報を取得して、編集画面に遷移する
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("index"));
        Book book = new BooksDAO().selectBookById(id);

        request.setAttribute("id", book.getId());
        request.setAttribute("title", book.getTitle());
        request.setAttribute("author", book.getAuthor());
        request.setAttribute("publisher", book.getPublisher());
        request.setAttribute("publishDate", book.getGetPublishDate());

        RequestDispatcher dispatcher = request.getRequestDispatcher("CollectionOfBooks/EditBook.jsp");
        dispatcher.forward(request, response);
    }
}
