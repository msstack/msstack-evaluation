package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.ibuy.orderservice.events.OrderAcceptedEvent;
import com.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import com.grydtech.ibuy.orderservice.events.OrderRejectedEvent;
import com.grydtech.msstack.core.handler.EventHandler;
import com.grydtech.msstack.util.DistributedLogger;
import com.grydtech.msstack.util.DistributedLoggerfactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.UUID;

@SuppressWarnings("unused")
public class ValidateOrderHandler implements EventHandler<OrderEntity, OrderCreatedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateOrderHandler.class.getName());
    private static final DistributedLogger DISTRIBUTED_LOGGER = DistributedLoggerfactory.getLogger(ValidateOrderHandler.class.getName());

    @Override
    public void handle(OrderCreatedEvent orderCreatedEvent, Map map, UUID uuid, OrderEntity orderEntity) {
        if (orderCreatedEvent.getAmount() < 10000) {
            OrderAcceptedEvent orderAcceptedEvent = new OrderAcceptedEvent(orderCreatedEvent.getOrderId());
            orderAcceptedEvent.emit(uuid);

            LOGGER.info("order accepted for order id: " + orderCreatedEvent.getOrderId());
            DISTRIBUTED_LOGGER.info("order accepted for order id: " + orderCreatedEvent.getOrderId());
        } else {
            OrderRejectedEvent orderRejectedEvent = new OrderRejectedEvent(orderCreatedEvent.getOrderId());
            orderRejectedEvent.emit(uuid);

            LOGGER.warn("order rejected sent with order id: " + orderCreatedEvent.getOrderId());
            DISTRIBUTED_LOGGER.warn("order rejected sent with order id: " + orderCreatedEvent.getOrderId());
        }
    }
}
