package org.example;

import java.sql.*;

//Edit
//Delete

public class UserDAO {
    private final Connection postgresConn;
    private Statement statement;

    public UserDAO(Connection postgresConn) {
        this.postgresConn = postgresConn;
        try {
            statement = postgresConn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void printAllUsers(){
        try {
            ResultSet resultSet = statement.executeQuery(SQLQueries.SELECT_ALL);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void createUser(int id, String name, String email) {
        try {
            PreparedStatement preparedStatement = postgresConn.prepareStatement(SQLQueries.INSERT_INTO_DB);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editUser(int id, String name, String email) {



    }
}
