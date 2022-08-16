package org.example;

import java.sql.*;

public class App
    //Connection - Interface
    //Statement - SQL statement
    //Resultset - set of results
{
    public static void main(String[] args) {
//        String url = "jdbc:postgresql://localhost/users";
//        String userName = "postgres";
//        String password = "root";
//        try {
//            Connection connection = DriverManager.getConnection(url, userName, password);
//            System.out.println("connected to database");
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        Connection postgresConn = ConnectionManager.connectToDB();
        UserDAO userDAO = new UserDAO(postgresConn);
        userDAO.createUser(3, "Danny", "danny@email.com");
        userDAO.createUser(4, "Laura", "laura@email.com");
        userDAO.printAllUsers();
        ConnectionManager.closeConnection();
    }
}
