package com.youtube_devedojo.jdbc.conn;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
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

    public static JdbcRowSet getJdbcRowSet() throws SQLException {
        String url, username, password;
        url = "jdbc:postgresql://localhost:5432/anime_store";
        username = "postgres";
        password = "esquelelord19";

        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
        jdbcRowSet.setUrl(url);
        jdbcRowSet.setUsername(username);
        jdbcRowSet.setPassword(password);

        return jdbcRowSet;

    }
    public static CachedRowSet getCachedRowSet() throws SQLException {
        String url, username, password;
        url = "jdbc:postgresql://localhost:5432/anime_store";
        username = "postgres";
        password = "esquelelord19";

        CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        cachedRowSet.setUrl(url);
        cachedRowSet.setUsername(username);
        cachedRowSet.setPassword(password);

        return cachedRowSet;

    }
}
