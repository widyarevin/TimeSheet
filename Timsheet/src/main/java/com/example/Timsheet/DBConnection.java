package com.example.Timsheet;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Timesheet", "root", "");
    } catch (Exception e) {
            System.out.println("Error + " + e.getMessage());
        }
        return con;
    }
}
