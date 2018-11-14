package com.grydtech.ibuy.orderservice.events;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.msstack.core.types.messaging.Event;

import java.util.UUID;

public class OrderRejectedEvent extends Event<OrderEntity> {

    private String orderId;

    public OrderRejectedEvent() {
    }

    public OrderRejectedEvent(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public UUID getEntityId() {
        return UUID.fromString(this.orderId);
    }

    @Override
    public Class<OrderEntity> getEntityClass() {
        return OrderEntity.class;
    }
}
