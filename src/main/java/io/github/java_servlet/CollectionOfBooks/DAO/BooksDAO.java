package io.github.java_servlet.CollectionOfBooks.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BooksDAO {
    private final String url = "jdbc:mysql://172.17.0.3:3306/CollectionOfBooks";
    private final String user = "root";
    private final String pass = "abc123";

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, user, pass);) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement pst = con.prepareStatement("SELECT ID, TITLE, AUTHOR, PUBLISHER, PUBLISH_DATE FROM BOOKS");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String publisher = rs.getString("PUBLISHER");
                Date publishDate = rs.getDate("PUBLISH_DATE");

                Book book = new Book(id, title, author, publisher, publishDate);
                books.add(book);
            }

        } catch (ClassNotFoundException e) {
            throw new  IllegalStateException("JDBCドライバーを読み込めませんでした");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public List<Book> getBookFromTitle(String bookTitle) {
        List<Book> books = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement pst = con.prepareStatement("SELECT ID, TITLE, AUTHOR, PUBLISHER, PUBLISH_DATE FROM BOOKS WHERE TITLE = ?");
            pst.setString(1, bookTitle);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String publisher = rs.getString("PUBLISHER");
                Date publishDate = rs.getDate("PUBLISH_DATE");

                Book book = new Book(id, title, author, publisher, publishDate);
                books.add(book);
            }

        } catch (ClassNotFoundException e) {
            throw new  IllegalStateException("JDBCドライバーを読み込めませんでした");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public List<Book> getBookFromAuthor(String bookAuthor) {
        List<Book> books = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement pst = con.prepareStatement("SELECT ID, TITLE, AUTHOR, PUBLISHER, PUBLISH_DATE FROM BOOKS WHERE AUTHOR = ?");
            pst.setString(1, bookAuthor);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String publisher = rs.getString("PUBLISHER");
                Date publishDate = rs.getDate("PUBLISH_DATE");

                Book book = new Book(id, title, author, publisher, publishDate);
                books.add(book);
            }

        } catch (ClassNotFoundException e) {
            throw new  IllegalStateException("JDBCドライバーを読み込めませんでした");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public List<Book> getBookFromPublish(String bookPublisher) {
        List<Book> books = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement pst = con.prepareStatement("SELECT ID, TITLE, AUTHOR, PUBLISHER, PUBLISH_DATE FROM BOOKS WHERE PUBLISHER = ?");
            pst.setString(1, bookPublisher);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String publisher = rs.getString("PUBLISHER");
                Date publishDate = rs.getDate("PUBLISH_DATE");

                Book book = new Book(id, title, author, publisher, publishDate);
                books.add(book);
            }

        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバーを読み込めませんでした");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public void Registration(Book book) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement pst = con.prepareStatement("INSERT INTO BOOKS(TITLE, AUTHOR, PUBLISHER, PUBLISH_DATE) VALUES(?, ?, ?, ?)");
            pst.setString(1, book.getTitle());
            pst.setString(2, book.getAuthor());
            pst.setString(3, book.getPublisher());
            pst.setDate(4, book.getGetPublishDate());
            pst.executeUpdate();

        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバーを読み込めませんでした");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
