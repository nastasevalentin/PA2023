package org.example;

import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        if (databaseManager.getConnection() != null) {
            System.out.println("Successfully connected to the database.");

            AuthorDAO authorDAO = new AuthorDAO();

            authorDAO.addAuthor("John Doe");

            try (ResultSet rs = authorDAO.getAuthors()) {
                while (rs.next()) {
                    System.out.println("Author ID: " + rs.getInt("id"));
                    System.out.println("Author Name: " + rs.getString("name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}