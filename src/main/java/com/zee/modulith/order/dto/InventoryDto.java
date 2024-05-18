package com.zee.modulith.order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 06 May, 2024
 */

public record InventoryDto(
        @NotBlank(message = "inventoryName cannot be blank") String inventoryName,
        @Min(value = 1L, message = "The value must be greater than zero") int qty){
}
