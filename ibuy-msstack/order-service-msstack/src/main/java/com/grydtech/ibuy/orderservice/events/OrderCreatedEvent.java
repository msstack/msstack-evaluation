package com.grydtech.ibuy.orderservice.events;

import com.grydtech.msstack.core.BasicEvent;
import com.grydtech.msstack.core.annotation.Event;

@Event(stream = "orders")
public class OrderCreatedEvent extends BasicEvent {

    private String orderId;
    private String customerId;

    public OrderCreatedEvent(String customerId) {
        this.customerId = customerId;
    }

    public OrderCreatedEvent(String orderId, String customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getOrderId() {
        return orderId;
    }
}