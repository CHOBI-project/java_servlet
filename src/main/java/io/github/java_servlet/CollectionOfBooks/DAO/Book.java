package io.github.java_servlet.CollectionOfBooks.DAO;

import java.io.Serializable;
import java.util.Date;

// 書籍情報を保持するクラス
public class Book implements Serializable {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private Date getPublishDate;

    public Book() {}
    public Book(int id, String title, String author, String publisher, Date getPublishDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.getPublishDate = getPublishDate;
    }

    public Book(String title, String author, String publisher, Date getPublishDate) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.getPublishDate = getPublishDate;
    }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setGetPublishDate(Date getPublishDate) { this.getPublishDate = getPublishDate; }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }
    public Date getGetPublishDate() { return getPublishDate; }
}
