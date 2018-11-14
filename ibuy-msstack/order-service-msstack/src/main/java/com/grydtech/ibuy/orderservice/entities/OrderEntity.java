package com.grydtech.ibuy.orderservice.entities;

import com.grydtech.ibuy.orderservice.events.OrderAcceptedEvent;
import com.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import com.grydtech.ibuy.orderservice.events.OrderRejectedEvent;
import com.grydtech.msstack.core.types.Entity;
import com.grydtech.msstack.core.types.messaging.Event;

import java.util.UUID;

public class OrderEntity extends Entity {

    private String orderId;
    private String customerId;
    private Double payment;
    private String status;

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Double getPayment() {
        return payment;
    }

    public String getStatus() {
        return status;
    }

    private void apply(OrderCreatedEvent event) {
        this.orderId = event.getOrderId();
        this.customerId = event.getCustomerId();
        this.payment = event.getAmount();
        this.status = "PENDING";
    }

    private void apply(OrderAcceptedEvent event) {
        this.status = "ACCEPTED";
    }

    private void apply(OrderRejectedEvent event) {
        this.status = "REJECTED";
    }

    @Override
    public UUID getEntityId() {
        return UUID.fromString(this.orderId);
    }

    @Override
    public void apply(Event event) {
        if (event instanceof OrderCreatedEvent) {
            this.apply((OrderCreatedEvent) event);
        } else if (event instanceof OrderAcceptedEvent) {
            this.apply((OrderAcceptedEvent) event);
        } else if (event instanceof OrderRejectedEvent) {
            this.apply((OrderRejectedEvent) event);
        }
    }
}
