package org.grydtech.ibuy.orderservice.handlers;

import org.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import org.grydtech.ibuy.orderservice.requests.OrderCreateRequest;
import org.grydtech.ibuy.orderservice.responses.GenericResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/create-order")
public class CreateOrderHandler {

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse handle(OrderCreateRequest orderCreateRequest) {
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent(orderCreateRequest.getCustomerId());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new GenericResponse(200, "success");
    }

}