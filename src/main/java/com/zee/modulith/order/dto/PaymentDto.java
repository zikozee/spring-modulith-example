package com.zee.modulith.order.dto;

import com.zee.modulith.eventaction.action.Action;
import com.zee.modulith.eventaction.action.CustomEventMarker;
import org.jmolecules.event.types.DomainEvent;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 08 May, 2024
 */

@CustomEventMarker(eventAction = Action.PAYMENT)
public record PaymentDto(String orderId, long amount) implements DomainEvent {}
