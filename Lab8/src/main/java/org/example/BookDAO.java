package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements DAO<Book> {
    private Connection connection;

    public BookDAO() {
        this.connection = DatabaseManager.getInstance().getConnection();
    }

    @Override
    public Book create(Book book) {
        String sql = "INSERT INTO books (title, language, publication_date, number_of_pages) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getLanguage());
            stmt.setDate(3, java.sql.Date.valueOf(book.getPublicationDate()));
            stmt.setInt(4, book.getNumberOfPages());
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    book.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error adding book", e);
        }
        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setLanguage(rs.getString("language"));
                book.setPublicationDate(rs.getDate("publication_date").toLocalDate());
                book.setNumberOfPages(rs.getInt("number_of_pages"));
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving books", e);
        }
        return books;
    }

    @Override
    public Book findByName(String name) {
        throw new UnsupportedOperationException("findByName operation is not supported for BookDAO");
    }

    @Override
    public Book findById(int id) {
        Book book = null;
        String sql = "SELECT * FROM books WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    book = new Book();
                    book.setId(rs.getInt("id"));
                    book.setTitle(rs.getString("title"));
                    book.setLanguage(rs.getString("language"));
                    book.setPublicationDate(rs.getDate("publication_date").toLocalDate());
                    book.setNumberOfPages(rs.getInt("number_of_pages"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving book", e);
        }
        return book;
    }
}