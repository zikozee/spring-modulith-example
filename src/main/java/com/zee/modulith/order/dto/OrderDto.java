package com.zee.modulith.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 06 May, 2024
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record OrderDto(
        String customerName,
        String customerEmail,
        String inventoryName,
        List<InventoryDto> inventories,
        String message,
        Integer statusCode) {

    public OrderDto(String message, Integer statusCode) {
        this(null, null, null, null, message, statusCode);
    }
}
