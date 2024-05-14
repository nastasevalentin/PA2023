package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        AuthorDAO authorDAO = new AuthorDAO();
        GenreDAO genreDAO = new GenreDAO();
        BookDAO bookDAO = new BookDAO();
        BookAuthorDAO bookAuthorDAO = new BookAuthorDAO();

        Author newAuthor = new Author("John Doe");
        newAuthor = authorDAO.create(newAuthor);
        System.out.println("Created new author with ID: " + newAuthor.getId());

        Genre newGenre = new Genre("Fiction");
        newGenre = genreDAO.create(newGenre);
        System.out.println("Created new genre with ID: " + newGenre.getId());

        Book newBook = new Book("Book Title", "English", LocalDate.now(), 200);
        newBook = bookDAO.create(newBook);
        System.out.println("Created new book with ID: " + newBook.getId());

        bookAuthorDAO.addAuthorToBook(newBook.getId(), newAuthor.getId());
        System.out.println("Added author to book");

        System.out.println("All authors:");
        for (Author author : authorDAO.findAll()) {
            System.out.println("ID: " + author.getId() + ", Name: " + author.getName());
        }

        System.out.println("All genres:");
        for (Genre genre : genreDAO.findAll()) {
            System.out.println("ID: " + genre.getId() + ", Name: " + genre.getName());
        }

        System.out.println("All books:");
        for (Book book : bookDAO.findAll()) {
            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Language: " + book.getLanguage() + ", Publication Date: " + book.getPublicationDate() + ", Number of Pages: " + book.getNumberOfPages());
        }

        Author foundAuthor = authorDAO.findByName("John Doe");
        if (foundAuthor != null) {
            System.out.println("Found author by name 'John Doe': ID: " + foundAuthor.getId() + ", Name: " + foundAuthor.getName());
        } else {
            System.out.println("Author 'John Doe' not found");
        }

        Genre foundGenre = genreDAO.findByName("Fiction");
        if (foundGenre != null) {
            System.out.println("Found genre by name 'Fiction': ID: " + foundGenre.getId() + ", Name: " + foundGenre.getName());
        } else {
            System.out.println("Genre 'Fiction' not found");
        }

        Book foundBook = bookDAO.findById(newBook.getId());
        if (foundBook != null) {
            System.out.println("Found book by ID: " + foundBook.getId() + ", Title: " + foundBook.getTitle() + ", Language: " + foundBook.getLanguage() + ", Publication Date: " + foundBook.getPublicationDate() + ", Number of Pages: " + foundBook.getNumberOfPages());
        } else {
            System.out.println("Book with ID " + newBook.getId() + " not found");
        }
    }
}