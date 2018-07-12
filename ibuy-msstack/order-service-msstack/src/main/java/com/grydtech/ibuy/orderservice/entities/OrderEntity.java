package com.grydtech.ibuy.orderservice.entities;

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

}
