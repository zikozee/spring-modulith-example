package com.zee.modulith.payment.typeconverter;

import com.zee.modulith.payment.type.PaymentStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 18 May, 2024
 */

@Converter(autoApply = true)
public class PaymentStatusConverter implements AttributeConverter<PaymentStatus, String> {

    @Override
    public String convertToDatabaseColumn(PaymentStatus status) {
        if (status == null) throw new IllegalArgumentException("Status can not be null");
        return status.getCode();
    }

    @Override
    public PaymentStatus convertToEntityAttribute(String code) {
        if (code == null) throw new IllegalArgumentException("Code can not be null");
        return Arrays.stream(PaymentStatus.values())
                .filter(status -> status.getCode().equalsIgnoreCase(code))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("invalud code"));
    }
}
