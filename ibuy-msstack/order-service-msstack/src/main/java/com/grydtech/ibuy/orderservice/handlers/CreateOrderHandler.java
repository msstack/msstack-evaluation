package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import com.grydtech.ibuy.orderservice.requests.OrderCreateRequest;
import com.grydtech.msstack.core.handler.CommandHandler;
import com.grydtech.msstack.util.DistributedLogger;
import com.grydtech.msstack.util.DistributedLoggerfactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.UUID;

@SuppressWarnings("unused")
public class CreateOrderHandler implements CommandHandler<OrderEntity, OrderCreateRequest> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateOrderHandler.class.getName());
    private static final DistributedLogger DISTRIBUTED_LOGGER = DistributedLoggerfactory.getLogger(CreateOrderHandler.class.getName());

    @Override
    public void handle(OrderCreateRequest orderCreateRequest, Map map, UUID uuid, OrderEntity orderEntity) {
        LOGGER.info("order create request received for order id: " + orderCreateRequest.getOrderId());
        DISTRIBUTED_LOGGER.info("order create request received for order id: " + orderCreateRequest.getOrderId());

        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent(orderCreateRequest.getOrderId(), orderCreateRequest.getCustomerId(), orderCreateRequest.getAmount());
        orderCreatedEvent.emit(uuid);

        LOGGER.info("order created for order id: " + orderCreatedEvent.getOrderId());
    }
}