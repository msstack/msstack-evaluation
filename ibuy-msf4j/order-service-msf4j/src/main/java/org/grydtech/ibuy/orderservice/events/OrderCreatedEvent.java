package org.grydtech.ibuy.orderservice.events;

public class OrderCreatedEvent {
    private String orderId;
    private String customerId;

    public OrderCreatedEvent(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public OrderCreatedEvent(String orderId, String customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }
}