package com.youtube_devedojo.jdbc.service;

import com.youtube_devedojo.jdbc.dominio.Producer;
import com.youtube_devedojo.jdbc.repository.ProducerRepositoryRowSet;

import java.util.List;

public class ProducerServiceJdbcRowSet {
    public static List<Producer> findByNameJdbcRowSet(String name) {
        return ProducerRepositoryRowSet.findByNameJdbcRowSet(name);
    }

    public static void updateJdbcRowSet(Producer producer) {
    ProducerRepositoryRowSet.updateJdbcRowSet(producer);
    }
    public static void updateCashedRowSet(Producer producer) {
        ProducerRepositoryRowSet.updateCashedRowSet(producer);
    }
}
