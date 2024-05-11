package com.zee.modulith.order;

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
    public void completeOrder(final PaymentDto paymentDto) {

        // create dto to be pushed to payment listener
        // publish to payment listener (remember to use @ApplicationModuleListener)

        log.info("Completing order with: {}", paymentDto);
        eventPublisher.publishEvent(paymentDto);
    }
}
