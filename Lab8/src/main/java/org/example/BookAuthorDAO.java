package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookAuthorDAO {
    private Connection connection;

    public BookAuthorDAO() {
        this.connection = DatabaseManager.getInstance().getConnection();
    }

    public void addAuthorToBook(int bookId, int authorId) {
        String sql = "INSERT INTO book_authors (book_id, author_id) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, bookId);
            stmt.setInt(2, authorId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding author to book", e);
        }
    }

    public void removeAuthorFromBook(int bookId, int authorId) {
        String sql = "DELETE FROM book_authors WHERE book_id = ? AND author_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, bookId);
            stmt.setInt(2, authorId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error removing author from book", e);
        }
    }

    public List<Author> getAuthorsForBook(int bookId) {
        List<Author> authors = new ArrayList<>();
        String sql = "SELECT a.* FROM authors a INNER JOIN book_authors ba ON a.id = ba.author_id WHERE ba.book_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, bookId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Author author = new Author();
                    author.setId(rs.getInt("id"));
                    author.setName(rs.getString("name"));
                    authors.add(author);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving authors for book", e);
        }
        return authors;
    }
}
