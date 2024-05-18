package com.zee.modulith.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 18 May, 2024
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CompleteOrder(
        @NotBlank(message = "orderIdentifier cannot be blank")
        String orderIdentifier,
        boolean paymentComplete) {
}
