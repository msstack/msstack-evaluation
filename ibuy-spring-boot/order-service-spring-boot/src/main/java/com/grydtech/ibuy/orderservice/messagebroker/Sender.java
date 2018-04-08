package com.grydtech.ibuy.orderservice.messagebroker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class Sender {

    private static ObjectMapper objectMapper;
    private static ExecutorService executorService;

    static {
        objectMapper = new ObjectMapper();
        executorService = new ThreadPoolExecutor(5, 10, 5000,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
    }

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Sender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, Object payload) {
            executorService.submit(() -> kafkaTemplate.send(topic, objectMapper.writeValueAsString(payload)));
    }
}
