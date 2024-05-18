package com.zee.modulith.payment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 05 May, 2024
 */

@Repository
interface PaymentRepository extends CrudRepository<Payment, Long> {
    Optional<Payment> findPaymentByOrderId(String orderId);
}
