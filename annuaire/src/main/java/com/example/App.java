package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        // Paramètres de connexion à PostgreSQL
        String url = "jdbc:postgresql://localhost:5432/db_annuaire"; 
        String user = "postgres"; 
        String password = "1234"; 

        // Tester la connexion
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion réussie à PostgreSQL !");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }
}
