package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO implements DAO<Author> {
    private Connection connection;

    public AuthorDAO() {
        this.connection = DatabaseManager.getInstance().getConnection();
    }

    @Override
    public Author create(Author author) {
        String sql = "INSERT INTO authors (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, author.getName());
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    author.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error adding author", e);
        }
        return author;
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        String sql = "SELECT * FROM authors";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Author author = new Author();
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));
                authors.add(author);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving authors", e);
        }
        return authors;
    }

    @Override
    public Author findByName(String name) {
        Author author = null;
        String sql = "SELECT * FROM authors WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    author = new Author();
                    author.setId(rs.getInt("id"));
                    author.setName(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving author", e);
        }
        return author;
    }

    @Override
    public Author findById(int id) {
        Author author = null;
        String sql = "SELECT * FROM authors WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    author = new Author();
                    author.setId(rs.getInt("id"));
                    author.setName(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving author", e);
        }
        return author;
    }
}