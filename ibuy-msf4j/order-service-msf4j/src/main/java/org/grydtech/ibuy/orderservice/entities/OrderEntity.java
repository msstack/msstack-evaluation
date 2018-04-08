package org.grydtech.ibuy.orderservice.entities;

import org.grydtech.ibuy.orderservice.events.OrderCreatedEvent;

import java.util.List;

public class OrderEntity {
    private String orderId;
    private String customerId;
    private Double payment;
    private List<ItemEntity> items;

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Double getPayment() {
        return payment;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void apply(OrderCreatedEvent orderCreatedEvent) {
        // add OrderCreatedEvent based logic here
    }
}
