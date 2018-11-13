package com.grydtech.ibuy.orderservice.events;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.msstack.core.types.messaging.Event;

import java.util.UUID;

public class OrderCreatedEvent extends Event<OrderEntity> {

    private String orderId;
    private String customerId;

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

    @Override
    public UUID getEntityId() {
        return UUID.fromString(orderId);
    }

    @Override
    public Class<OrderEntity> getEntityClass() {
        return OrderEntity.class;
    }
}