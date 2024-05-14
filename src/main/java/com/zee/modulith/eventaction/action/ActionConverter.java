package com.zee.modulith.eventaction.action;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 14 May, 2024
 */

@Converter(autoApply = true)
public class ActionConverter implements AttributeConverter<Action, String> {

    @Override
    public String convertToDatabaseColumn(Action action) {
        if(action != null)
            return action.getCode();
        throw new IllegalArgumentException("action is null");
    }

    @Override
    public Action convertToEntityAttribute(String code) {
        if(code == null)  throw new IllegalArgumentException("code is null");
        return Arrays.stream(Action.values())
                .filter(action -> action.getCode().equals(code))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("action not found"));
    }
}
