package br.com.inovalocal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/inovalocal_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection obter() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}