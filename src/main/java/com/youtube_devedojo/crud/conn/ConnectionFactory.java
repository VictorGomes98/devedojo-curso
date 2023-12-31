package com.youtube_devedojo.crud.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        String url, username, password;
        url = "jdbc:postgresql://localhost:5432/anime_store";
        username = "postgres";
        password = "esquelelord19";
        return DriverManager.getConnection(url, username, password);
    }
}
