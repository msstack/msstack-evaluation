package com.grydtech.ibuy.orderservice.responses;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.msstack.core.types.messaging.Response;

import java.util.UUID;

public class GetOrderResponse extends Response<OrderEntity> {

    private String orderId;
    private OrderEntity orderEntity;

    public GetOrderResponse() {
    }

    public GetOrderResponse(String orderId, OrderEntity orderEntity) {
        this.orderId = orderId;
        this.orderEntity = orderEntity;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
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
