package co.com.leojoss.repository.interfaces;

import java.util.List;

import co.com.leojoss.model.Book;

public interface BookRepository {
    public void save(Book book);

    public Book findById(String id);

    List<Book> findAll();

    Book findBookById(String bookId); 

    void updateBook(Book book);
}
