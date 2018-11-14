package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import com.grydtech.ibuy.orderservice.requests.OrderCreateRequest;
import com.grydtech.msstack.core.handler.CommandHandler;

import java.util.Map;
import java.util.UUID;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class CreateOrderHandler implements CommandHandler<OrderEntity, OrderCreateRequest> {

    private static Logger LOGGER = LogManager.getLogManager().getLogger(CreateOrderHandler.class.getName());

    @Override
    public void handle(OrderCreateRequest orderCreateRequest, Map map, UUID uuid, OrderEntity orderEntity) {
        LOGGER.info("order create request received for order id: " + orderCreateRequest.getOrderId());
        // add logic before order created event
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent(orderCreateRequest.getOrderId(), orderCreateRequest.getCustomerId(), orderCreateRequest.getAmount());
        orderCreatedEvent.emit(uuid);
        // add logic after order created event
        LOGGER.info("order created for order id: " + orderCreatedEvent.getOrderId());
    }
}