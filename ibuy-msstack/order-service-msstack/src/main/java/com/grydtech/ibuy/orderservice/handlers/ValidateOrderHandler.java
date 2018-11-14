package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.ibuy.orderservice.events.OrderAcceptedEvent;
import com.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import com.grydtech.ibuy.orderservice.events.OrderRejectedEvent;
import com.grydtech.msstack.core.handler.EventHandler;

import java.util.Map;
import java.util.UUID;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class ValidateOrderHandler implements EventHandler<OrderEntity, OrderCreatedEvent> {

    private static Logger LOGGER = LogManager.getLogManager().getLogger(ValidateOrderHandler.class.getName());

    @Override
    public void handle(OrderCreatedEvent orderCreatedEvent, Map map, UUID uuid, OrderEntity orderEntity) {
        LOGGER.info("OrderCreatedEvent received with order id: " + orderCreatedEvent.getOrderId());
        if (orderCreatedEvent.getAmount() < 10000) {
            OrderAcceptedEvent orderAcceptedEvent = new OrderAcceptedEvent(orderCreatedEvent.getOrderId());
            orderAcceptedEvent.emit(uuid);
            LOGGER.info("order accepted for order id: " + orderCreatedEvent.getOrderId());
        } else {
            OrderRejectedEvent orderRejectedEvent = new OrderRejectedEvent(orderCreatedEvent.getOrderId());
            orderRejectedEvent.emit(uuid);
            LOGGER.info("order rejected sent with order id: " + orderCreatedEvent.getOrderId());
        }
    }
}
