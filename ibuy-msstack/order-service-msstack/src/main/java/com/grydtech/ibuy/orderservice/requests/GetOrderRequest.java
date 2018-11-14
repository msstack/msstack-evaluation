package com.grydtech.ibuy.orderservice.requests;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.msstack.core.types.messaging.Query;

import java.util.UUID;

public class GetOrderRequest extends Query<OrderEntity> {

    private String orderId;

    public GetOrderRequest() {
    }

    public GetOrderRequest(String orderId) {
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
