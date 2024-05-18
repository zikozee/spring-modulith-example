package com.zee.modulith.payment;

import com.zee.modulith.order.dto.CompleteOrder;
import com.zee.modulith.order.dto.PaymentDto;
import com.zee.modulith.payment.type.PaymentStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 09 May, 2024
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentManagement {
    private final PaymentRepository paymentRepository;

    @ApplicationModuleListener
    void on(final PaymentDto paymentDto) {
//        throw new RuntimeException("event publication failed for orderId: "+ paymentDto.orderId());

        System.out.println("listener received :"+ paymentDto);

        Payment payment = new Payment();
        payment.setOrderId(paymentDto.orderId());
        payment.setAmount(paymentDto.amount());
        paymentRepository.save(payment);
    }

    @ApplicationModuleListener
    void on(final CompleteOrder completeOrder) {
//        throw new RuntimeException("event publication failed for orderId: "+ paymentDto.orderId());

        System.out.println("listener received completed order: "+ completeOrder);

        Optional<Payment> optionalPayment =  paymentRepository.findPaymentByOrderId(completeOrder.orderIdentifier());

        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            payment.setStatus(PaymentStatus.COMPLETED);
            paymentRepository.save(payment);
        }
    }
}
