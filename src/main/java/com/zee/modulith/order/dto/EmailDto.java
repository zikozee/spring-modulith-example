package com.zee.modulith.order.dto;

import com.zee.modulith.eventaction.action.Action;
import com.zee.modulith.eventaction.action.CustomEventMarker;
import org.jmolecules.event.types.DomainEvent;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 18 May, 2024
 */

@CustomEventMarker(eventAction = Action.EMAIL)
public record EmailDto(String email, String customerName, String orderIdentifier, long totalAmount, boolean orderComplete) implements DomainEvent { }
