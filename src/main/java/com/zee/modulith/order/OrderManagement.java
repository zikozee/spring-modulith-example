package com.zee.modulith.order;

import com.zee.modulith.order.dto.PaymentDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 06 May, 2024
 */

@Service
@RequiredArgsConstructor
public class OrderManagement {


    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void completeOrder(final PaymentDto paymentDto) {

        // create dto to be pushed to payment listener
        // publish to payment listener (remember to use @ApplicationModuleListener)

    }
}
