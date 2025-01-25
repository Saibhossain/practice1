package org.example.demo1.chat;

import java.sql.*;


public class databaseConnection {
    private static final String url = "jdbc:mysql://localhost:3308/javaproject";
    private static final String username = "root";
    private static final String password = "";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }


}
