package com.youtube_devedojo.jdbc.repository;

import com.youtube_devedojo.jdbc.conn.ConnectionFactory;
import com.youtube_devedojo.jdbc.dominio.Producer;
import com.youtube_devedojo.jdbc.listener.CustomRowSetListener;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerRepositoryRowSet {
    public static List<Producer> findByNameJdbcRowSet(String name){
        String sql = "SELECT * FROM producer WHERE name ILIKE ?;";
        List<Producer> producers = new ArrayList<>();
        try(JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setString(1, String.format("%%%s%%", name));
            jrs.execute();
            while (jrs.next()){
                Producer producer = Producer.builder()
                        .id(jrs.getInt("id"))
                        .name(jrs.getString("name"))
                        .build();
                producers.add(producer);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producers;
    }
//    public static void updateJdbcRowSet(Producer producer){
//        String sql = "UPDATE producer SET name = ? WHERE id = ?;";
//        try(JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
//            jrs.setCommand(sql);
//            jrs.setString(1, producer.getName());
//            jrs.setInt(2, producer.getId());
//            jrs.execute();
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public static void updateJdbcRowSet(Producer producer){
        String sql = "SELECT * FROM producer WHERE id = ?;";
        try(JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setInt(1, producer.getId());
            jrs.execute();
            if (!jrs.next()) return;
            jrs.updateString("name", producer.getName());
            jrs.updateRow();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateCashedRowSet(Producer producer){
        String sql = "SELECT * FROM producer WHERE id = ?;";
        try(CachedRowSet crs = ConnectionFactory.getCachedRowSet();
            Connection connection = ConnectionFactory.getConnection()) {
            connection.setAutoCommit(false);
            crs.setCommand(sql);
            crs.setInt(1, producer.getId());
            crs.execute(connection);
            if (!crs.next()) return;
            crs.updateString("name", producer.getName());
            crs.updateRow();
            crs.acceptChanges();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
