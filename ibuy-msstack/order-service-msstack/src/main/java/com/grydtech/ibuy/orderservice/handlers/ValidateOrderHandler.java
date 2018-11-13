package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import com.grydtech.ibuy.orderservice.responses.OrderAcceptedResponse;
import com.grydtech.ibuy.orderservice.responses.OrderRejectedResponse;
import com.grydtech.msstack.core.handler.EventHandler;

import java.util.Map;
import java.util.UUID;

@SuppressWarnings("unused")
public class ValidateOrderHandler implements EventHandler<OrderEntity, OrderCreatedEvent> {
    @Override
    public void handle(OrderCreatedEvent orderCreatedEvent, Map map, UUID uuid, OrderEntity orderEntity) {
        if (orderEntity.getCustomerId().equals("")) {
            OrderRejectedResponse orderRejectedResponse = new OrderRejectedResponse(orderCreatedEvent.getOrderId(), 400, "order rejected. invalid customer id");
            orderRejectedResponse.emit(uuid);
        } else {
            OrderAcceptedResponse orderAcceptedResponse = new OrderAcceptedResponse(orderCreatedEvent.getOrderId(), 200, "order accepted");
            orderAcceptedResponse.emit(uuid);
        }
    }
}
