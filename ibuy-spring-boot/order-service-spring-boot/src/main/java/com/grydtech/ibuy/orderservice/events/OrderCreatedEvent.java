package com.grydtech.ibuy.orderservice.events;

public class OrderCreatedEvent {

    private String customerId;

    public OrderCreatedEvent(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
