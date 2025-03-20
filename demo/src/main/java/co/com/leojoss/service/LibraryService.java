package co.com.leojoss.service;

import java.util.ArrayList;
import java.util.List;

import co.com.leojoss.enums.BookCategory;
import co.com.leojoss.exception.BookAlreadyBorrowedException;
import co.com.leojoss.exception.NoSuchElementException;
import co.com.leojoss.exception.UserNotFoundException;
import co.com.leojoss.model.Book;
import co.com.leojoss.model.Loan;
import co.com.leojoss.model.User;
import co.com.leojoss.repository.interfaces.BookRepository;
import co.com.leojoss.repository.interfaces.LoanRepository;

public class LibraryService {
    // Dependencias
    private BookRepository bookRepository;
    private LoanRepository loanRepository;
    private ArrayList<User> users;

    // Constructor
    public LibraryService(BookRepository bookRepository, LoanRepository loanRepository) {
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
        this.users = new ArrayList<>();
    }

    public void addBook(String id, String title, String author, BookCategory category) {
        bookRepository.save(new Book(id, title, author, category));
    }

    public User addUser(String id, String name) {
        // Verificar si el usuario ya existe
        User user = new User(id, name);
        users.add(user);
        return user;
    }

    public Book findBookById(String id) {
        // Verificar si el libro existe
        Book book = bookRepository.findById(id);
        if (book == null) {
            // Si el libro no existe, lanzar una excepción
            throw new NoSuchElementException("Libro con ID " + id + " no encontrado.");
        }
        // Devolver el libro
        return book;
    }

    public Loan borrowBook(User user, Book book) {
        // Verificar si el usuario existe
        if (!users.contains(user)) {
            // Si el usuario no existe, lanzar una excepción
            throw new UserNotFoundException("Usuario no registrado.");
        }

        // Verificar si el libro está disponible
        if (book.isBorrowed()) {
            // Si el libro ya esta prestado, lanzar una excepción
            throw new BookAlreadyBorrowedException("El libro ya está prestado.");
        }

        // Marcar el libro como prestado
        book.setBorrowed(true);

        // Guardar el préstamo
        return loanRepository.save(new Loan(user, book));
    }

    public List<Loan> getLoansByUser(User user) {
        // Verificar si el usuario existe
        if (!users.contains(user)) {
            // Si el usuario no existe, lanzar una excepción
            throw new UserNotFoundException("Usuario no registrado");
        }
        // Buscar los préstamos del usuario
        return loanRepository.findByUser(user);
    }

    public int getAvailableBooksCount() {
        int count = 0;
        for (Book book : bookRepository.findAll()) {
            if (!book.isBorrowed()) {
                count++;
            }
        }
        return count;
    }

    public List<Book> findAvailableBooksByCategory(BookCategory category) {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            if (book.getCategory() == category && !book.isBorrowed()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public User findUserById(String userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null; // Usuario no encontrado
    }

    public boolean returnBook(String bookId) {
        Book book = bookRepository.findBookById(bookId); // Busca el libro por ID
        if (book != null && book.isBorrowed()) {
            book.setBorrowed(false); // Marca el libro como no prestado
            bookRepository.updateBook(book); // Actualiza el libro en el repositorio
            return true;
        }
        return false;
    }
}
