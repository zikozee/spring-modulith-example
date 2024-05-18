package com.zee.modulith.order;

import com.zee.modulith.order.dto.CompleteOrder;
import com.zee.modulith.order.dto.EmailDto;
import com.zee.modulith.order.dto.PaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 06 May, 2024
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderManagement {

    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void completeOrder(final PaymentDto paymentDto, final EmailDto emailDto) {

        log.info("Completing order with: {}", paymentDto);
        eventPublisher.publishEvent(paymentDto);

        log.info("Sending email for order: {}", emailDto);
        eventPublisher.publishEvent(emailDto);
    }

    @Transactional
    public void completePayment(final CompleteOrder completeOrder, final EmailDto emailDto) {

        log.info("Attempting to complete payment: {}", completeOrder);
        eventPublisher.publishEvent(completeOrder);

        log.info("Completed Payment Email: {}", completeOrder);
        eventPublisher.publishEvent(emailDto);
    }
}
