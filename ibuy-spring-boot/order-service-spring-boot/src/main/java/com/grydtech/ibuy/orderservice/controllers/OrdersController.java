package com.grydtech.ibuy.orderservice.controllers;

import com.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import com.grydtech.ibuy.orderservice.messagebroker.Sender;
import com.grydtech.ibuy.orderservice.requests.CreateOrderRequest;
import com.grydtech.ibuy.orderservice.responses.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class OrdersController {

    private Sender sender;

    @Autowired
    public OrdersController(Sender sender) {
        this.sender = sender;
    }

    @PostMapping(value = "create-order", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse createOrder(CreateOrderRequest createOrderRequest) {
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent(createOrderRequest.getCustomerId());
        sender.send("order-created-event", orderCreatedEvent);
        return new GenericResponse(200, "success");
    }
}
