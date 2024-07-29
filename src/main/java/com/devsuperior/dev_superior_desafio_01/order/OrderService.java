package com.devsuperior.dev_superior_desafio_01.order;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order){

        double shippingValue = this.shippingService.shipment(order);

        double basicWithDiscount = order.getBasic() - order.getBasic() * (order.getDiscount() / 100);

        return  basicWithDiscount + shippingValue;

    }


}
