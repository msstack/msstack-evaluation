package com.grydtech.ibuy.orderservice.events;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.msstack.core.types.messaging.Event;

import java.util.UUID;

public class OrderAcceptedEvent extends Event<OrderEntity> {

    private String orderId;

    public OrderAcceptedEvent() {
    }

    public OrderAcceptedEvent(String orderId) {
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
