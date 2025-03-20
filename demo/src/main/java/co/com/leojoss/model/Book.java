package co.com.leojoss.model;

import co.com.leojoss.enums.BookCategory;

public class Book {
    private final String title;
    private final String author;
    private final String id;
    private final BookCategory category;
    private boolean borrowed;

    public Book(String id, String title, String author, BookCategory category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public BookCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Libro Titulo=" + title + ", author=" + author + ", id=" + id + ", categoria=" + category + ", prestado="
                + borrowed;
    }

}
