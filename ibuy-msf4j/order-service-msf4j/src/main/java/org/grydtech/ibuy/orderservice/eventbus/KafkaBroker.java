package org.grydtech.ibuy.orderservice.eventbus;


public class KafkaBroker {

    private final KafkaSender kafkaSender;

    public KafkaBroker() {
        kafkaSender = new KafkaSender();
    }

    public void publish(String topic, String message) {
        kafkaSender.send(topic, message);
    }
}
