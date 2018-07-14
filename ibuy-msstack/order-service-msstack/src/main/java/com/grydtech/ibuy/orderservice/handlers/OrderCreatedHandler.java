package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import com.grydtech.msstack.core.handler.EventHandler;

public class OrderCreatedHandler implements EventHandler<OrderCreatedEvent> {
    @Override
    public void handle(OrderCreatedEvent event) {
        System.out.println("Order created with id: " + event.getOrderId());
    }
}
