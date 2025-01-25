package org.example.demo1.chat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthService {
    public boolean login(String email, String password, String userType) {
        String query = "";
        if (userType.equalsIgnoreCase("student")) {
            query = "SELECT * FROM student WHERE email = ? AND password = ?";
        } else if (userType.equalsIgnoreCase("supporter")) {
            query = "SELECT * FROM supporter WHERE email = ? AND password = ?";
        }

        try (Connection conn = databaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
