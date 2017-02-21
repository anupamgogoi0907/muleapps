package com.anupam.snake.model;

/**
 * Created by ac-agogoi on 2/21/17.
 */
public class Book {

    private String bookTitle;
    private String isbn;

    public Book() {
    }

    public Book(String bookTitle, String isbn) {
        this.bookTitle = bookTitle;
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
