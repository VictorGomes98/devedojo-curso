package com.youtube_devedojo.jdbc.test;

import com.youtube_devedojo.jdbc.dominio.Producer;
import com.youtube_devedojo.jdbc.service.ProducerServiceJdbcRowSet;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionTest02 {
    public static void main(String[] args) {
        Producer producerToUpdate = Producer.builder().id(1).name("MADHOUSE").build();
        ProducerServiceJdbcRowSet.updateCashedRowSet(producerToUpdate);
//        log.info("----------------------------------------------------------------");
//        List<Producer> producers = ProducerServiceJdbcRowSet.findByNameJdbcRowSet("");
//        log.info(producers);
    }
}
