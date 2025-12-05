package com.backend_wpost;

import java.sql.*;

public class TestPostgresConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/backend_wpost";
        String user = "postgres";
        String password = "123456";

        System.out.println("Probando conexión a: " + url);

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ CONEXIÓN EXITOSA!");
            System.out.println("Base de datos: " + conn.getCatalog());
            conn.close();
        } catch (SQLException e) {
            System.out.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
