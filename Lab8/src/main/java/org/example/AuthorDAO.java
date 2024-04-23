package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDAO {
    private Connection connection;

    public AuthorDAO() {
        this.connection = DatabaseManager.getInstance().getConnection();
    }

    public void addAuthor(String name) {
        String sql = "INSERT INTO authors (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding author", e);
        }
    }

    public ResultSet getAuthors() {
        String sql = "SELECT * FROM authors";
        try {
            return connection.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving authors", e);
        }
    }
}