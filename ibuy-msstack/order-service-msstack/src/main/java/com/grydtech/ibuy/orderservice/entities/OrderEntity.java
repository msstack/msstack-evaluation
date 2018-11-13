package com.grydtech.ibuy.orderservice.entities;

import com.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import com.grydtech.msstack.core.types.Entity;
import com.grydtech.msstack.core.types.messaging.Event;

import java.util.UUID;

public class OrderEntity extends Entity {

    private String orderId;
    private String customerId;
    private Double payment;

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Double getPayment() {
        return payment;
    }

    private void apply(OrderCreatedEvent event) {
        this.orderId = event.getOrderId();
        this.customerId = event.getCustomerId();
        this.payment = 0.00;
    }

    @Override
    public UUID getEntityId() {
        return UUID.fromString(this.orderId);
    }

    @Override
    public void apply(Event event) {
        if (event instanceof OrderCreatedEvent) {
            this.apply((OrderCreatedEvent) event);
        }
    }
}
