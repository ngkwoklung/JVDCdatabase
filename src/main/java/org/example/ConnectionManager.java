package org.example;

import org.example.util.PropertiesLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection postgresConn;

    public static Connection connectToDB() {
        String url = PropertiesLoader.getProperty("url");
        String userName = PropertiesLoader.getProperty("userName");
        String password = PropertiesLoader.getProperty("password");
        try {
            postgresConn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postgresConn;
    }

    public static void closeConnection() {
        try {
            postgresConn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
