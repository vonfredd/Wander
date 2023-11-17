package com.wanderers.wander.dockerSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    public static Connection connect() throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/mysql";
        String user = "root";
        String password = "password";

        return DriverManager.getConnection(jdbcUrl, user, password);
    }

    public static void main(String[] args) {
        try (Connection connection = connect()) {
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
