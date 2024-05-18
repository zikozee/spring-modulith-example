package com.zee.modulith.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 18 May, 2024
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CompleteOrder(String orderIdentifier, boolean paymentComplete) {
}
