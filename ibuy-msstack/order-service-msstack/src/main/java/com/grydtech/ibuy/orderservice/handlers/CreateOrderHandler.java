package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import com.grydtech.ibuy.orderservice.requests.OrderCreateRequest;
import com.grydtech.msstack.core.handler.CommandHandler;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.UUID;

@SuppressWarnings("unused")
public class CreateOrderHandler implements CommandHandler<OrderEntity, OrderCreateRequest> {

    private static Logger LOGGER = LogManager.getLogger(CreateOrderHandler.class);

    @Override
    public void handle(OrderCreateRequest orderCreateRequest, Map map, UUID uuid, OrderEntity orderEntity) {
        LOGGER.info("OrderCreateRequest received with order id: " + orderCreateRequest.getOrderId());
        // add logic before order created event
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent(orderCreateRequest.getOrderId(), orderCreateRequest.getCustomerId());
        orderCreatedEvent.emit(uuid);
        // add logic after order created event
        LOGGER.info("OrderCreatedEvent emitted with order id: " + orderCreatedEvent.getOrderId());
    }
}