package com.extreamsoft.productservice.core.events;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCreatedEvent {

    private String productId;
    private BigDecimal price;
    private String title;
    private Integer quantity;
}
