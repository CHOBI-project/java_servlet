package io.github.java_servlet.CollectionOfBooks.DAO;

import java.sql.*;
import java.util.ArrayList;

public class BooksDAO {
    private final String url = "jdbc:mysql://database:3306/CollectionOfBooks";
    private final String user = "root";
    private final String pass = "abc123";

    // 書籍全情報を取得する
    public ArrayList<Book> selectBooks() {
        ArrayList<Book> books = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
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
            throw new IllegalStateException("JDBCドライバーを読み込めませんでした");
        } catch (SQLException e) {
            throw new IllegalStateException("SQLで何らかの問題が発生しました");
        }

        return books;
    }

    // 書籍情報をID検索で取得する
    public Book selectBookById(int ID) {
        Book book = null;

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement pst = con.prepareStatement("SELECT ID, TITLE, AUTHOR, PUBLISHER, PUBLISH_DATE FROM BOOKS WHERE ID = ?");
            pst.setInt(1, ID);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String publisher = rs.getString("PUBLISHER");
                Date publishDate = rs.getDate("PUBLISH_DATE");

                book = new Book(id, title, author, publisher, publishDate);
            }

        } catch (ClassNotFoundException e) {
            throw new  IllegalStateException("JDBCドライバーを読み込めませんでした");
        } catch (SQLException e) {
            throw new IllegalStateException("SQLで何らかの問題が発生しました");
        }

        return book;
    }

    // 書籍情報をタイトル検索で取得する
    public ArrayList<Book> selectBooksByTitle(String bookTitle) {
        ArrayList<Book> books = new ArrayList<>();

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
            throw new IllegalStateException("SQLで何らかの問題が発生しました");
        }

        return books;
    }

    // 書籍情報を著者検索で取得する
    public ArrayList<Book> selectBooksByAuthor(String bookAuthor) {
        ArrayList<Book> books = new ArrayList<>();

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
            throw new IllegalStateException("SQLで何らかの問題が発生しました");
        }

        return books;
    }

    // 書籍情報を出版社検索で取得する
    public ArrayList<Book> selectBooksByPublisher(String bookPublisher) {
        ArrayList<Book> books = new ArrayList<>();

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
            throw new IllegalStateException("SQLで何らかの問題が発生しました");
        }

        return books;
    }

    // 書籍情報を登録する
    public void insertBook(Book book) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement pst = con.prepareStatement("INSERT INTO BOOKS(TITLE, AUTHOR, PUBLISHER, PUBLISH_DATE) VALUES(?, ?, ?, ?)");
            pst.setString(1, book.getTitle());
            pst.setString(2, book.getAuthor());
            pst.setString(3, book.getPublisher());

            java.sql.Date sqlDate = new java.sql.Date(book.getGetPublishDate().getTime());
            pst.setDate(4, sqlDate);
            pst.executeUpdate();

        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバーを読み込めませんでした");
        } catch (SQLException e) {
            throw new IllegalStateException("SQLで何らかの問題が発生しました");
        }
    }

    // 書籍情報を更新する
    public void updateBook(Book book) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement pst = con.prepareStatement("UPDATE BOOKS SET TITLE = ?, AUTHOR = ?, PUBLISHER = ?, PUBLISH_DATE = ? WHERE ID = ?");
            pst.setString(1, book.getTitle());
            pst.setString(2, book.getAuthor());
            pst.setString(3, book.getPublisher());
            java.sql.Date sqlDate = new java.sql.Date(book.getGetPublishDate().getTime());
            pst.setDate(4, sqlDate);
            pst.setInt(5, book.getId());
            pst.executeUpdate();

        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバーを読み込めませんでした");
        } catch (SQLException e) {
            throw new IllegalStateException("SQLで何らかの問題が発生しました");
        }
    }

    // 書籍情報を削除する
    public void deleteBook(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement pst = con.prepareStatement("DELETE FROM BOOKS WHERE ID = ?");
            pst.setInt(1, id);
            pst.execute();

        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバーを読み込めませんでした");
        } catch (SQLException e) {
            throw new IllegalStateException("SQLで何らかの問題が発生しました");
        }
    }
}
