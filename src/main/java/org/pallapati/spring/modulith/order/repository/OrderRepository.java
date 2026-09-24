package org.pallapati.spring.modulith.order.repository;

import org.pallapati.spring.modulith.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

interface OrderRepository extends JpaRepository<Order, Long> {
}
