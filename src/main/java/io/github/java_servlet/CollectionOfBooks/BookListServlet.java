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
import java.util.ArrayList;

@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 本の一覧を取得
        ArrayList<Book> books = new BooksDAO().selectBooks();
        request.setAttribute("books", books);

        // BookList.jspに遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("CollectionOfBooks/BookList.jsp");
        dispatcher.forward(request, response);
    }

    // 検索条件に一致する本の一覧を取得
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");

        if ((title == null || title.isEmpty()) &&
                (author == null || author.isEmpty()) &&
                (publisher == null || publisher.isEmpty())) {

            request.setAttribute("title", title);
            request.setAttribute("author", author);
            request.setAttribute("publisher", publisher);
            request.setAttribute("errorMsg", "検索条件を入力してください");
            request.setAttribute("books", new BooksDAO().selectBooks());
            RequestDispatcher dispatcher = request.getRequestDispatcher("CollectionOfBooks/BookList.jsp");
            dispatcher.forward(request, response);
            return;
        }

        ArrayList<Book> books = new ArrayList<>();

        // 入力値ごとにロジックを分岐
        if (title != null && !title.isEmpty()) {
            ArrayList<Book> bookTitle = new BooksDAO().selectBooksByTitle(title);
            if (bookTitle != null && !bookTitle.isEmpty()) {
                books.addAll(bookTitle); // 入力値があり、結果が存在する場合に追加
            } else {
                books.add(null);
            }
        }

        if (author != null && !author.isEmpty()) {
            ArrayList<Book> bookAuthor = new BooksDAO().selectBooksByAuthor(author);
            if (bookAuthor != null && !bookAuthor.isEmpty()) {
                books.addAll(bookAuthor); // 入力値があり、結果が存在する場合に追加
            } else {
                books.add(null);
            }
        }

        if (publisher != null && !publisher.isEmpty()) {
            ArrayList<Book> bookPublisher = new BooksDAO().selectBooksByPublisher(publisher);
            if (bookPublisher != null && !bookPublisher.isEmpty()) {
                books.addAll(bookPublisher); // 入力値があり、結果が存在する場合に追加
            } else {
                books.add(null);
            }
        }

        request.setAttribute("books", books);

        RequestDispatcher dispatcher = request.getRequestDispatcher("CollectionOfBooks/BookList.jsp");
        dispatcher.forward(request, response);
    }
}

