package co.com.leojoss.view;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.time.Instant;

import co.com.leojoss.enums.BookCategory;
import co.com.leojoss.model.Book;
import co.com.leojoss.model.Loan;
import co.com.leojoss.model.User;
import co.com.leojoss.repository.interfaces.BookRepository;
import co.com.leojoss.repository.interfaces.LoanRepository;
import co.com.leojoss.service.LibraryService;
import co.com.leojoss.utils.BookInitializer;
import co.com.leojoss.utils.BookRepositoryImpl;
import co.com.leojoss.utils.LoanRepositoryImpl;

public class Main {

    public static void main(String[] args) {
        LocalDateTime fechaHora = LocalDateTime.now();

        // Definir el formato en español
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("EEE dd 'de' MMMM 'de' yyyy HH:mm:ss",
                new Locale("es", "ES"));

        // Formatear la fecha y hora
        String fechaEnEspanol = fechaHora.format(formato);

        // Mostrar la fecha en español
        System.out.println("Fecha en español: " + fechaEnEspanol);

        // Instanciar los repositorios y el servicio
        BookRepository bookRepository = new BookRepositoryImpl();
        LoanRepository loanRepository = new LoanRepositoryImpl();
        LibraryService libraryService = new LibraryService(bookRepository, loanRepository);

        initializeBooks(libraryService);

        // Menú interactivo
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n=== Menú de la Biblioteca ===");
            System.out.println("1. Buscar libros por categoría");
            System.out.println("2. Ver disponibilidad de un libro");
            System.out.println("3. Registrar un nuevo usuario");
            System.out.println("4. Realizar un préstamo");
            System.out.println("5. Mostrar detalles de un préstamo");
            System.out.println("6. Mostrar cantidad de libros disponibles");
            System.out.println("7. Devolver un libro");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (option) {
                case 1:
                    searchBooksByCategory(libraryService, scanner);
                    break;
                case 2:
                    checkBookAvailability(libraryService, scanner);
                    break;
                case 3:
                    registerUser(libraryService, scanner);
                    break;
                case 4:
                    borrowBook(libraryService, scanner);
                    break;
                case 5:
                    showLoanDetails(libraryService, scanner);
                    break;
                case 6:
                    showAvailableBooksCount(libraryService);
                    break;
                case 7:
                    returnBook(libraryService, scanner);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 0);

        scanner.close();
    }

    private static void initializeBooks(LibraryService libraryService) {
        // Obtener la lista de libros desde BookInitializer
        List<Book> books = BookInitializer.initializeBooks();

        // Agregar los libros al sistema
        for (Book book : books) {
            libraryService.addBook(book.getId(), book.getTitle(), book.getAuthor(), book.getCategory());
        }
    }

    private static void searchBooksByCategory(LibraryService libraryService, Scanner scanner) {
        System.out.println("\n=== Categorías Disponibles ===");
        for (BookCategory category : BookCategory.values()) {
            System.out.println((category.ordinal() + 1) + ". " + category);
        }
        System.out.print("Seleccione una categoría (o escriba '0' para volver al menú): ");
        int categoryIndex = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        if (categoryIndex == 0) {
            System.out.println("Volviendo al menú principal...");
            return;
        }

        if (categoryIndex < 1 || categoryIndex > BookCategory.values().length) {
            System.out.println("Categoría no válida.");
            return;
        }

        BookCategory selectedCategory = BookCategory.values()[categoryIndex - 1];
        List<Book> availableBooks = libraryService.findAvailableBooksByCategory(selectedCategory);

        if (availableBooks.isEmpty()) {
            System.out.println("No hay libros disponibles en la categoría " + selectedCategory + ".");
        } else {
            System.out.println("\n=== Libros Disponibles en " + selectedCategory + " ===");
            for (Book book : availableBooks) {
                System.out.println("ID: " + book.getId());
                System.out.println("Título: " + book.getTitle());
                System.out.println("Autor: " + book.getAuthor());
                System.out.println("-----------------------------");
            }
        }
    }

    private static void checkBookAvailability(LibraryService libraryService, Scanner scanner) {
        System.out.print("Ingrese el ID del libro (o escriba 'salir' para volver al menú): ");
        String id = scanner.nextLine();

        if (id.equalsIgnoreCase("salir")) {
            System.out.println("Volviendo al menú principal...");
            return;
        }

        // Normalizar el ID a mayúsculas
        String idNormalizado = id.toUpperCase();

        // Buscar el libro
        Book book = libraryService.findBookById(idNormalizado);
        if (book != null) {
            if (book.isBorrowed()) {
                System.out.println("El libro está prestado.");
            } else {
                System.out.println("El libro está disponible.");
            }
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void registerUser(LibraryService libraryService, Scanner scanner) {
        System.out.print("Ingrese el ID del usuario: ");
        String id = scanner.nextLine();

        // Verificar si el usuario ya existe
        if (libraryService.findUserById(id) != null) {
            System.out.println("El usuario ya está registrado.");
            return;
        }

        System.out.print("Ingrese el nombre del usuario: ");
        String name = scanner.nextLine();
        User user = libraryService.addUser(id, name);
        System.out.println("Usuario registrado: " + user.getName());
    }

    private static void borrowBook(LibraryService libraryService, Scanner scanner) {
        System.out.print("Ingrese el ID del usuario: ");
        String userId = scanner.nextLine();
        System.out.print("Ingrese el ID del libro: ");
        String bookId = scanner.nextLine();

        // Normalizar el ID del libro a mayúsculas
        String bookIdNormalizado = bookId.toUpperCase();

        // Buscar el usuario registrado
        User user = libraryService.findUserById(userId);
        if (user == null) {
            System.out.println("Usuario no registrado.");
            return;
        }

        // Buscar el libro
        Book book = libraryService.findBookById(bookIdNormalizado);
        if (book != null && !book.isBorrowed()) {
            Loan loan = libraryService.borrowBook(user, book);

            // Convertir java.util.Date a LocalDateTime
            java.util.Date date = loan.getDate();
            Instant instant = date.toInstant();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

            // Formatear la fecha en español
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("EEE dd 'de' MMM 'de' yyyy HH:mm:ss",
                    Locale.of("es", "ES"));
            String fechaFormateada = localDateTime.format(formato);

            System.out.println("Préstamo realizado:");
            System.out.println("Usuario: " + loan.getUser().getName());
            System.out.println("Libro: " + loan.getBook().getTitle());
            System.out.println("Fecha: " + fechaFormateada);
        } else {
            System.out.println("No se pudo realizar el préstamo. Verifique el ID del libro o su disponibilidad.");
        }
    }

    private static void showLoanDetails(LibraryService libraryService, Scanner scanner) {
        System.out.print("Ingrese el ID del usuario: ");
        String userId = scanner.nextLine();

        // Verificar si el usuario existe
        User user = libraryService.findUserById(userId);
        if (user == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        List<Loan> loans = libraryService.getLoansByUser(user);
        if (loans.isEmpty()) {
            System.out.println("No se encontraron préstamos para este usuario.");
        } else {
            System.out.println("Préstamos del usuario " + userId + ":");
            for (Loan loan : loans) {
                System.out.println("Libro: " + loan.getBook().getTitle());
                System.out.println("Fecha: " + loan.getDate());
                System.out.println("-----------------------------");
            }
        }
    }

    private static void returnBook(LibraryService libraryService, Scanner scanner) {
        System.out.print("Ingrese el ID del libro a devolver: ");
        String bookId = scanner.nextLine();

        // Normalizar el ID del libro a mayúsculas
        String bookIdNormalizado = bookId.toUpperCase();

        if (libraryService.returnBook(bookIdNormalizado)) {
            System.out.println("Libro devuelto correctamente.");
        } else {
            System.out.println("No se pudo devolver el libro. Verifique el ID del libro.");
        }
    }

    private static void showAvailableBooksCount(LibraryService libraryService) {
        int availableBooks = libraryService.getAvailableBooksCount();
        System.out.println("Cantidad de libros disponibles: " + availableBooks);
    }
}