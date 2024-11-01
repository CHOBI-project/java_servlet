package io.github.java_servlet.CollectionOfBooks.BookList;

import io.github.java_servlet.CollectionOfBooks.DAO.Book;
import io.github.java_servlet.CollectionOfBooks.DAO.BooksDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = new BooksDAO().getAllBooks();
        request.setAttribute("books", books);

        RequestDispatcher dispatcher = request.getRequestDispatcher("CollectionOfBooks/BookList/BookList.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");

        if ((title == null || title.isEmpty()) &&
                (author == null || author.isEmpty()) &&
                (publisher == null || publisher.isEmpty())) {

            request.setAttribute("errorMsg", "検索条件を入力してください");
            request.setAttribute("books", new BooksDAO().getAllBooks());
            RequestDispatcher dispatcher = request.getRequestDispatcher("CollectionOfBooks/BookList/BookList.jsp");
            dispatcher.forward(request, response);
            return;
        }

        BooksDAO booksDAO = new BooksDAO();
        List<Book> books = new ArrayList<>();

        if (title != null && !title.isEmpty()) {
            books = booksDAO.getBookFromTitle(title);
        } else if (author != null && !author.isEmpty()) {
            books = booksDAO.getBookFromAuthor(author);
        } else {
            books = booksDAO.getBookFromPublish(publisher);
        }

        if (books.isEmpty()) {
            request.setAttribute("errorMsg", "蔵書が見つかりませんでした。");
        }

        request.setAttribute("title", title);
        request.setAttribute("author", author);
        request.setAttribute("publisher", publisher);
        request.setAttribute("books", books);

        RequestDispatcher dispatcher = request.getRequestDispatcher("CollectionOfBooks/BookList/BookList.jsp");
        dispatcher.forward(request, response);
    }
}