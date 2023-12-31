package com.youtube_devedojo.jdbc.test;

import com.youtube_devedojo.jdbc.dominio.Producer;
import com.youtube_devedojo.jdbc.service.ProducerService;

import java.util.List;

public class ConnectionTest03 {
    public static void main(String[] args) {
        Producer producer1 = Producer.builder().name("Toei Animation").build();
        Producer producer2 = Producer.builder().name("White Fox").build();
        Producer producer3 = Producer.builder().name("Studio Ghibli").build();
        ProducerService.saveTransaction(List.of(producer1, producer2, producer3));

//        ProducerService.findByNameAndDelete("Toei Animation");
//        ProducerService.findByNameAndDelete("White Fox");
//        ProducerService.findByNameAndDelete("Studio Ghibli");
    }
}
