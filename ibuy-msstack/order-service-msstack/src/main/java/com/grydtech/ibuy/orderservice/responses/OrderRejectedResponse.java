package com.grydtech.ibuy.orderservice.responses;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.msstack.core.types.messaging.Response;

import java.util.UUID;

public class OrderRejectedResponse extends Response<OrderEntity> {
    private String orderId;
    private Integer status;
    private String message;

    public OrderRejectedResponse() {
    }

    public OrderRejectedResponse(String orderId, Integer status, String message) {
        this.orderId = orderId;
        this.status = status;
        this.message = message;
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
