package co.com.leojoss.utils;

import co.com.leojoss.model.Book;
import co.com.leojoss.repository.interfaces.BookRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepositoryImpl implements BookRepository {

    // Mapa para almacenar los libros, donde la clave es el ID del libro
    private Map<String, Book> books = new HashMap<>();

    @Override
    public void save(Book book) {
        // Agrega el libro al Map usando su ID como clave
        books.put(book.getId(), book);
    }

    @Override
    public Book findById(String id) {
        // Busca un libro por su ID en el Map
        return books.get(id);
    }

    @Override
    public List<Book> findAll() {
        // Retorna una lista con todos los libros (valores del Map)
        return new ArrayList<>(books.values());
    }

    @Override
    public Book findBookById(String bookId) {
        // Busca el libro por ID en el Map
        return books.get(bookId);
    }

    @Override
    public void updateBook(Book book) {
        // Actualiza el libro en el Map
        books.put(book.getId(), book);
    }
}
