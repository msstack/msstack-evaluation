package com.grydtech.ibuy.orderservice;

import com.grydtech.msstack.core.MicroserviceApplication;
import com.grydtech.msstack.core.MicroserviceRunner;

public class OrderServiceApplication extends MicroserviceApplication {

    public static void main(String[] args) throws Exception {
        MicroserviceRunner.run(OrderServiceApplication.class);
    }
}
