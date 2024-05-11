package com.zee.modulith.order.dto;

import org.jmolecules.event.types.DomainEvent;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 08 May, 2024
 */

public record PaymentDto(String orderId, long amount) implements DomainEvent {}
