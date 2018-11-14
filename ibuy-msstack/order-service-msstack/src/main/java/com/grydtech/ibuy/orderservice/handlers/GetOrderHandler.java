package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.ibuy.orderservice.requests.GetOrderRequest;
import com.grydtech.ibuy.orderservice.responses.GetOrderResponse;
import com.grydtech.msstack.core.handler.QueryHandler;

import java.util.Map;
import java.util.UUID;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class GetOrderHandler implements QueryHandler<OrderEntity, GetOrderRequest> {

    private static Logger LOGGER = LogManager.getLogManager().getLogger(GetOrderHandler.class.getName());

    @Override
    public void handle(GetOrderRequest getOrderRequest, Map map, UUID uuid, OrderEntity orderEntity) {
        LOGGER.info("get order request received for order id: " + getOrderRequest.getOrderId());
        GetOrderResponse getOrderResponse = new GetOrderResponse(getOrderRequest.getOrderId(), orderEntity);
        getOrderResponse.emit(uuid);
        LOGGER.info("get order response sent for order id: " + getOrderRequest.getOrderId());
    }
}
