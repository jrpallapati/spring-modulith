package org.pallapati.spring.modulith.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public record Order(@Id Long id, String name, String description, int price, int quantity) {
}
