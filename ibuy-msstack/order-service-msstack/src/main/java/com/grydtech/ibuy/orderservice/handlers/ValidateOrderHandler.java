package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import com.grydtech.ibuy.orderservice.responses.OrderAcceptedResponse;
import com.grydtech.ibuy.orderservice.responses.OrderRejectedResponse;
import com.grydtech.msstack.core.handler.EventHandler;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.UUID;

@SuppressWarnings("unused")
public class ValidateOrderHandler implements EventHandler<OrderEntity, OrderCreatedEvent> {

    private static Logger LOGGER = LogManager.getLogger(ValidateOrderHandler.class);

    @Override
    public void handle(OrderCreatedEvent orderCreatedEvent, Map map, UUID uuid, OrderEntity orderEntity) {
        LOGGER.info("OrderCreatedEvent received with order id: " + orderCreatedEvent.getOrderId());
        if (orderEntity.getCustomerId().equals("")) {
            OrderRejectedResponse orderRejectedResponse = new OrderRejectedResponse(orderCreatedEvent.getOrderId(), 400, "order rejected. invalid customer id");
            orderRejectedResponse.emit(uuid);
            LOGGER.info("OrderRejectedResponse sent with order id: " + orderCreatedEvent.getOrderId());
        } else {
            OrderAcceptedResponse orderAcceptedResponse = new OrderAcceptedResponse(orderCreatedEvent.getOrderId(), 200, "order accepted");
            orderAcceptedResponse.emit(uuid);
            LOGGER.info("OrderAcceptedResponse sent with order id: " + orderCreatedEvent.getOrderId());
        }
    }
}
