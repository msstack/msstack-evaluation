package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import com.grydtech.ibuy.orderservice.requests.OrderCreateRequest;
import com.grydtech.ibuy.orderservice.responses.GenericResponse;
import com.grydtech.msstack.core.handler.CommandHandler;

import javax.ws.rs.Path;

@Path("/order/create-order")
public class CreateOrderHandler implements CommandHandler<OrderCreateRequest, GenericResponse> {

    @Path("")
    public GenericResponse handle(OrderCreateRequest orderCreateRequest) {
        new OrderCreatedEvent("CR001", orderCreateRequest.getCustomerId()).emit();
        System.out.println("Order created with id: CR001");
        return new GenericResponse(200, "success");
    }

}