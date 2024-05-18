package com.zee.modulith.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 06 May, 2024
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record OrderDto(
        @NotBlank(message = "customerName cannot be blank") String customerName,
        @NotBlank(message = "customerEmail cannot be blank") String customerEmail,
        @Valid List<InventoryDto> inventories,
        String message,
        Integer statusCode,
        PaymentDto paymentDto) {

    public OrderDto(String message, Integer statusCode, PaymentDto paymentDto) {
        this(null, null, null, message, statusCode, paymentDto);
    }
}
