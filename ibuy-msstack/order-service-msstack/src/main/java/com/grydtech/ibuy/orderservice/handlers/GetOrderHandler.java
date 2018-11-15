package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.entities.OrderEntity;
import com.grydtech.ibuy.orderservice.requests.GetOrderRequest;
import com.grydtech.ibuy.orderservice.responses.GetOrderResponse;
import com.grydtech.msstack.core.handler.QueryHandler;
import com.grydtech.msstack.util.DistributedLogger;
import com.grydtech.msstack.util.DistributedLoggerfactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.UUID;

@SuppressWarnings("unused")
public class GetOrderHandler implements QueryHandler<OrderEntity, GetOrderRequest> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetOrderHandler.class.getName());
    private static final DistributedLogger DISTRIBUTED_LOGGER = DistributedLoggerfactory.getLogger(GetOrderHandler.class.getName());

    @Override
    public void handle(GetOrderRequest getOrderRequest, Map map, UUID uuid, OrderEntity orderEntity) {
        LOGGER.info("get order request received for order id: " + getOrderRequest.getOrderId());
        DISTRIBUTED_LOGGER.info("get order request received for order id: " + getOrderRequest.getOrderId());

        GetOrderResponse getOrderResponse = new GetOrderResponse(getOrderRequest.getOrderId(), orderEntity);
        getOrderResponse.emit(uuid);

        LOGGER.info("order sent for order id: " + getOrderRequest.getOrderId());
    }
}
