package com.grydtech.ibuy.orderservice.responses;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.msstack.core.types.messaging.Response;

import java.util.UUID;

public class OrderAcceptedResponse extends Response<OrderEntity> {
    private String orderId;
    private Integer status;
    private String message;

    public OrderAcceptedResponse() {
    }

    public OrderAcceptedResponse(String orderId, Integer status, String message) {
        this.orderId = orderId;
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
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