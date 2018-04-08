package org.grydtech.ibuy.orderservice.eventbus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CaseFormat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public final class EventBus {
    private static KafkaBroker kafkaBroker;
    private static ObjectMapper objectMapper;

    static {
        kafkaBroker = new KafkaBroker();
        objectMapper = new ObjectMapper();
    }

    private EventBus() {
    }

    public static void publish(Object event) {
        String topic = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, event.getClass().getSimpleName());
        try {
            EventBus.kafkaBroker.publish(topic, objectMapper.writeValueAsString(event));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
