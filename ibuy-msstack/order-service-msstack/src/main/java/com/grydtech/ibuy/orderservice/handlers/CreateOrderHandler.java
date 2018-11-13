package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import com.grydtech.ibuy.orderservice.requests.OrderCreateRequest;
import com.grydtech.ibuy.orderservice.responses.OrderAcceptedResponse;
import com.grydtech.msstack.core.handler.CommandHandler;

import java.util.Map;
import java.util.UUID;

@SuppressWarnings("unused")
public class CreateOrderHandler implements CommandHandler<OrderEntity, OrderCreateRequest> {

    @Override
    public void handle(OrderCreateRequest orderCreateRequest, Map map, UUID uuid, OrderEntity orderEntity) {
        // add logic before order created event
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent(orderCreateRequest.getOrderId(), orderCreateRequest.getCustomerId());
        orderCreatedEvent.emit(uuid);
        // add logic after order created event
    }
}