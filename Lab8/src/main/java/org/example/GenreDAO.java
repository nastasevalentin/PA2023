package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO implements DAO<Genre> {
    private Connection connection;

    public GenreDAO() {
        this.connection = DatabaseManager.getInstance().getConnection();
    }

    @Override
    public Genre create(Genre genre) {
        String sql = "INSERT INTO genres (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, genre.getName());
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    genre.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error adding genre", e);
        }
        return genre;
    }

    @Override
    public List<Genre> findAll() {
        List<Genre> genres = new ArrayList<>();
        String sql = "SELECT * FROM genres";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Genre genre = new Genre();
                genre.setId(rs.getInt("id"));
                genre.setName(rs.getString("name"));
                genres.add(genre);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving genres", e);
        }
        return genres;
    }

    @Override
    public Genre findByName(String name) {
        Genre genre = null;
        String sql = "SELECT * FROM genres WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    genre = new Genre();
                    genre.setId(rs.getInt("id"));
                    genre.setName(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving genre", e);
        }
        return genre;
    }

    @Override
    public Genre findById(int id) {
        Genre genre = null;
        String sql = "SELECT * FROM genres WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    genre = new Genre();
                    genre.setId(rs.getInt("id"));
                    genre.setName(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving genre", e);
        }
        return genre;
    }
}