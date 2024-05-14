package com.zee.modulith.eventaction.action;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 11 May, 2024
 */

@AllArgsConstructor
@Getter
public enum Action {
    PAYMENT("P"), EMAIL("E");

    private final String code;


    public static Action getActionByName(final String name) {
        return Arrays.stream(Action.values())
                .filter(action -> action.name().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }
}
