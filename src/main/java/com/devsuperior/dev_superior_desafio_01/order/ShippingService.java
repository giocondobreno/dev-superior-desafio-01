package com.devsuperior.dev_superior_desafio_01.order;

import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {

        double basic = order.getBasic();

        if (basic < 100) {
            return 20;
        } else if (basic < 200) {
            return 12;
        } else {
            return 0;
        }

    }

}
