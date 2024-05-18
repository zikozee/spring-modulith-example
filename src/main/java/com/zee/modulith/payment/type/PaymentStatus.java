package com.zee.modulith.payment.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 18 May, 2024
 */

@Getter
@AllArgsConstructor
public enum PaymentStatus {
    INCOMPLETE("I"), COMPLETED("C"), FAILED("F");

    private final String code;
}
