package co.com.leojoss.utils;

import java.util.ArrayList;
import java.util.List;

import co.com.leojoss.enums.BookCategory;
import co.com.leojoss.model.Book;

public class BookInitializer {
    public static List<Book> initializeBooks() {
        List<Book> books = new ArrayList<>();

        // Agregar libros de ejemplo

        // Libros de Física
        books.add(new Book("FISICA-1", "Física para Ingenieros", "Josias Orozco", BookCategory.FISICA));
        books.add(new Book("FISICA-2", "Electronica Digital", "Paul A. Tipler", BookCategory.FISICA));
        books.add(new Book("FISICA-3", "Conceptos de Física", "Douglas C. Giancoli", BookCategory.FISICA));
        books.add(new Book("FISICA-4", "Física Moderna", "Sears y Zemansky", BookCategory.FISICA));
        books.add(new Book("FISICA-5", "Física Universitaria", "David Halliday, Robert Resnick y Jearl Walker",
                BookCategory.FISICA));

        // Libros de Electrónica
        books.add(new Book("ELECTRONICA-1", "Electrónica: Teoría de Circuitos", "Robert L. Boylestad",
                BookCategory.ELECTRONICA));
        books.add(new Book("ELECTRONICA-2", "Principios de Electrónica", "Albert Paul Malvino",
                BookCategory.ELECTRONICA));
        books.add(new Book("ELECTRONICA-3", "Electrónica de Potencia", "Daniel W. Hart", BookCategory.ELECTRONICA));
        books.add(new Book("ELECTRONICA-4", "Diseño Electrónico: Circuitos y Sistemas", "C. J. Savant Jr.",
                BookCategory.ELECTRONICA));
        books.add(new Book("ELECTRONICA-5", "Microelectrónica: Circuitos y Dispositivos", "Donald A. Neamen",
                BookCategory.ELECTRONICA));

        // Libros de Novela
        books.add(new Book("NOVELA-1", "Cien Años de Soledad", "Gabriel García Márquez", BookCategory.NOVELA));
        books.add(new Book("NOVELA-2", "1984", "George Orwell", BookCategory.NOVELA));
        books.add(new Book("NOVELA-3", "Don Quijote de la Mancha", "Miguel de Cervantes", BookCategory.NOVELA));
        books.add(new Book("NOVELA-4", "Orgullo y Prejuicio", "Jane Austen", BookCategory.NOVELA));
        books.add(
                new Book("NOVELA-5", "Crónica de una Muerte Anunciada", "Gabriel García Márquez", BookCategory.NOVELA));

        // Libros de Ingeniería
        books.add(new Book("INGENIERIA-1", "Introducción a la Ingeniería: Un Enfoque Basado en Proyectos",
                "Paul H. Wright", BookCategory.INGENIERIA));
        books.add(new Book("INGENIERIA-2", "Ingeniería Mecánica: Estática", "Russell C. Hibbeler",
                BookCategory.INGENIERIA));
        books.add(new Book("INGENIERIA-3", "Ingeniería de Software: Un Enfoque Práctico", "Roger S. Pressman",
                BookCategory.INGENIERIA));
        books.add(new Book("INGENIERIA-4", "Fundamentos de Ingeniería Eléctrica",
                "Charles K. Alexander y Matthew N. O. Sadiku", BookCategory.INGENIERIA));
        books.add(
                new Book("INGENIERIA-5", "Ingeniería de Control Moderna", "Katsuhiko Ogata", BookCategory.INGENIERIA));

        // Libros de Tecnología
        books.add(new Book("TECNOLOGIA-1", "Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin",
                BookCategory.TECNOLOGIA));
        books.add(new Book("TECNOLOGIA-2", "The Pragmatic Programmer: Your Journey to Mastery",
                "Andrew Hunt y David Thomas", BookCategory.TECNOLOGIA));
        books.add(new Book("TECNOLOGIA-3", "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Erich Gamma, Richard Helm, Ralph Johnson y John Vlissides", BookCategory.TECNOLOGIA));
        books.add(new Book("TECNOLOGIA-4", "Introduction to the Theory of Computation", "Michael Sipser",
                BookCategory.TECNOLOGIA));
        books.add(new Book("TECNOLOGIA-5", "Artificial Intelligence: A Modern Approach",
                "Stuart Russell y Peter Norvig", BookCategory.TECNOLOGIA));

        // Libros de Biología
        books.add(new Book("BIOLOGIA-1", "Biología", "Neil A. Campbell y Jane B. Reece", BookCategory.BIOLOGIA));
        books.add(new Book("BIOLOGIA-2", "El Gen Egoísta", "Richard Dawkins", BookCategory.BIOLOGIA));
        books.add(new Book("BIOLOGIA-3", "Biología Molecular de la Célula",
                "Bruce Alberts, Alexander Johnson, Julian Lewis, David Morgan, Martin Raff, Keith Roberts y Peter Walter",
                BookCategory.BIOLOGIA));
        books.add(new Book("BIOLOGIA-4", "La Doble Hélice", "James D. Watson", BookCategory.BIOLOGIA));
        books.add(new Book("BIOLOGIA-5", "Biología: La Unidad y la Diversidad de la Vida",
                "Cecie Starr, Ralph Taggart y Christine Evers", BookCategory.BIOLOGIA));

        // Libros de Deporte
        books.add(new Book("DEPORTE-1", "Fútbol: La Filosofía de lo Imposible", "Jorge Valdano", BookCategory.DEPORTE));
        books.add(new Book("DEPORTE-2", "El Fútbol a Sol y Sombra", "Eduardo Galeano", BookCategory.DEPORTE));
        books.add(new Book("DEPORTE-3", "Entrenamiento Funcional Aplicado a los Deportes", "Michael Boyle",
                BookCategory.DEPORTE));
        books.add(new Book("DEPORTE-4", "La Mente del Campeón", "Jim Afremow", BookCategory.DEPORTE));
        books.add(new Book("DEPORTE-5", "Correr con los Keniatas", "Adharanand Finn", BookCategory.DEPORTE));

        // Libros de Superación personal
        books.add(new Book("SUPERACION-1", "Los 7 Hábitos de la Gente Altamente Efectiva", "Stephen R. Covey",
                BookCategory.SUPERACION));
        books.add(new Book("SUPERACION-2", "El Poder del Ahora", "Eckhart Tolle", BookCategory.SUPERACION));
        books.add(new Book("SUPERACION-3", "Cómo Ganar Amigos e Influir sobre las Personas", "Dale Carnegie",
                BookCategory.SUPERACION));
        books.add(new Book("SUPERACION-4", "El Monje que Vendió su Ferrari", "Robin Sharma", BookCategory.SUPERACION));
        books.add(new Book("SUPERACION-5", "Atomic Habits: An Easy & Proven Way to Build Good Habits & Break Bad Ones",
                "James Clear", BookCategory.SUPERACION));

        // Libros de Historia
        books.add(new Book("HISTORIA-1", "Sapiens: De Animales a Dioses", "Yuval Noah Harari", BookCategory.HISTORIA));
        books.add(new Book("HISTORIA-2", "Breve Historia del Mundo", "Ernst H. Gombrich", BookCategory.HISTORIA));
        books.add(new Book("HISTORIA-3", "Los Mitos Griegos", "Robert Graves", BookCategory.HISTORIA));
        books.add(new Book("HISTORIA-4", "La Segunda Guerra Mundial", "Antony Beevor", BookCategory.HISTORIA));
        books.add(new Book("HISTORIA-5", "Historia Mínima de México", "Daniel Cosío Villegas, Lorenzo Meyer, y otros",
                BookCategory.HISTORIA));

        // Libros de Matemáticas
        books.add(new Book("MATEMATICAS-1", "Cálculo: Trascendentes Tempranas", "James Stewart",
                BookCategory.MATEMATICAS));
        books.add(new Book("MATEMATICAS-2", "Álgebra Lineal y sus Aplicaciones", "David C. Lay",
                BookCategory.MATEMATICAS));
        books.add(new Book("MATEMATICAS-3", "Introducción a la Teoría de Números",
                "Ivan Niven, Herbert S. Zuckerman y Hugh L. Montgomery", BookCategory.MATEMATICAS));
        books.add(new Book("MATEMATICAS-4", "Ecuaciones Diferenciales con Aplicaciones", "Dennis G. Zill",
                BookCategory.MATEMATICAS));
        books.add(new Book("MATEMATICAS-5", "Matemáticas Discretas y sus Aplicaciones", "Kenneth H. Rosen",
                BookCategory.MATEMATICAS));

        // Libros de Ciencias
        books.add(
                new Book("CIENCIAS-1", "El Universo en una Cáscara de Nuez", "Stephen Hawking", BookCategory.CIENCIAS));
        books.add(new Book("CIENCIAS-2", "Cosmos", "Carl Sagan", BookCategory.CIENCIAS));
        books.add(new Book("CIENCIAS-3", "Breve Historia del Tiempo", "Stephen Hawking", BookCategory.CIENCIAS));
        books.add(new Book("CIENCIAS-4", "El Genio de los Números", "Hans Magnus Enzensberger", BookCategory.CIENCIAS));
        books.add(new Book("CIENCIAS-5", "La Estructura de las Revoluciones Científicas", "Thomas S. Kuhn",
                BookCategory.CIENCIAS));

        // Libros de Literatura
        books.add(new Book("LITERATURA-1", "Cien Años de Soledad", "Gabriel García Márquez", BookCategory.LITERATURA));
        books.add(new Book("LITERATURA-2", "Don Quijote de la Mancha", "Miguel de Cervantes", BookCategory.LITERATURA));
        books.add(new Book("LITERATURA-3", "1984", "George Orwell", BookCategory.LITERATURA));
        books.add(new Book("LITERATURA-4", "Orgullo y Prejuicio", "Jane Austen", BookCategory.LITERATURA));
        books.add(new Book("LITERATURA-5", "La Odisea", "Homero", BookCategory.LITERATURA));

        // Libros de Psicología
        books.add(
                new Book("PSICOLOGIA-1", "El Hombre en Busca de Sentido", "Viktor E. Frankl", BookCategory.PSICOLOGIA));
        books.add(new Book("PSICOLOGIA-2", "Inteligencia Emocional", "Daniel Goleman", BookCategory.PSICOLOGIA));
        books.add(new Book("PSICOLOGIA-3", "Psicología del exito", "Mario Luna", BookCategory.PSICOLOGIA));
        books.add(new Book("PSICOLOGIA-4", "El Poder del Ahora", "Eckhart Tolle", BookCategory.PSICOLOGIA));
        books.add(
                new Book("PSICOLOGIA-5", "Pensar Rápido, Pensar Despacio", "Daniel Kahneman", BookCategory.PSICOLOGIA));

        // Libros de Economía
        books.add(new Book("ECONOMIA-1", "El Capital en el Siglo XXI", "Thomas Piketty", BookCategory.ECONOMIA));
        books.add(new Book("ECONOMIA-2",
                "Freakonomics: Un Economista Políticamente Incorrecto Explora el Lado Oculto de lo que nos Afecta",
                "Steven D. Levitt y Stephen J. Dubner", BookCategory.ECONOMIA));
        books.add(new Book("ECONOMIA-3", "La Riqueza de las Naciones", "Adam Smith", BookCategory.ECONOMIA));
        books.add(new Book("ECONOMIA-4", "Economía Básica: Un Manual de Economía Escrito desde el Sentido Común",
                "Thomas Sowell", BookCategory.ECONOMIA));
        books.add(new Book("ECONOMIA-5", "El Crash de 1929", "John Kenneth Galbraith", BookCategory.ECONOMIA));

        // Libros de Política
        books.add(new Book("POLITICA-1", "El Príncipe", "Nicolás Maquiavelo", BookCategory.POLITICA));
        books.add(new Book("POLITICA-2", "El Arte de la Guerra", "Sun Tzu", BookCategory.POLITICA));
        books.add(new Book("POLITICA-3", "El Leviatán", "Thomas Hobbes", BookCategory.POLITICA));
        books.add(new Book("POLITICA-4", "La República", "Platón", BookCategory.POLITICA));
        books.add(new Book("POLITICA-5", "El Contrato Social", "Jean-Jacques Rousseau", BookCategory.POLITICA));

        return books;
    }
}
