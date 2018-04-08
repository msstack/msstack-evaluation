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
    private static ExecutorService executorService;
    private static ObjectMapper objectMapper;

    static {
        kafkaBroker = new KafkaBroker();
        objectMapper = new ObjectMapper();

        // ToDo: Temporary implementation (corePoolSize, maximumPoolSize, keepAliveTime hardcoded)
        executorService = new ThreadPoolExecutor(5, 10, 5000,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
    }

    private EventBus() {
    }

    public static void publish(Object event) {
        executorService.submit(() -> {
            String topic = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, event.getClass().getSimpleName());
            String message = null;
            try {
                message = objectMapper.writeValueAsString(event);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            EventBus.kafkaBroker.publish(topic, message);
        });
    }
}
