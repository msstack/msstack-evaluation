package com.grydtech.ibuy.orderservice;

import com.grydtech.msstack.core.Application;
import com.grydtech.msstack.core.MicroServiceRunner;

public class OrderServiceApplication extends Application {

    public static void main(String[] args) throws Exception {
        MicroServiceRunner.run(OrderServiceApplication.class, args);
    }
}
