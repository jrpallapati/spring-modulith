package org.pallapati.spring.modulith.order.controller;

import org.pallapati.spring.modulith.order.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderManagement {
    @GetMapping("/order")
    public Order getOrder() {
        return new Order(1L, "Test", "Test", 10, 1);
    }
}
