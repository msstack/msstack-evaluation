package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import com.grydtech.ibuy.orderservice.requests.OrderCreateRequest;
import com.grydtech.ibuy.orderservice.responses.GenericResponse;
import com.grydtech.msstack.core.handler.CommandHandler;

import javax.ws.rs.Path;

@Path("/orders")
public class CreateOrderHandler implements CommandHandler<OrderCreateRequest, GenericResponse> {

    @Path("/create")
    public GenericResponse handle(OrderCreateRequest orderCreateRequest) {
        new OrderCreatedEvent("CR001", orderCreateRequest.getCustomerId()).emit();
        return new GenericResponse(200, "success");
    }

}