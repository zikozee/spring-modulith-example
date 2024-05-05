package com.zee.modulith.order.typeconverter;

import com.zee.modulith.order.type.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 06 May, 2024
 */


@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {
    @Override
    public String convertToDatabaseColumn(Status status) {

        return Arrays.stream(Status.values())
                .filter(s -> s == status)
                .map(Status::getCode)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Status convertToEntityAttribute(String code) {
        return Arrays.stream(Status.values())
                .filter(s -> s.getCode().equals(code))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
