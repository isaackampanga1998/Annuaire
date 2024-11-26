package com.example.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/db_annuaire";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public void ajouterMembre(String nom, String prenom, String email) {
        String sql = "INSERT INTO membres (nom, prenom, email) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, email);
            pstmt.executeUpdate();
            System.out.println("Membre ajouté à la base de données.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String rechercherMembre(String nom) {
        String sql = "SELECT * FROM membres WHERE nom = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("prenom") + " " + rs.getString("email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Membre non trouvé.";
    }

    public void supprimerMembre(String nom) {
        String sql = "DELETE FROM membres WHERE nom = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            pstmt.executeUpdate();
            System.out.println("Membre supprimé de la base de données.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

