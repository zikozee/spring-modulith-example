package com.zee.modulith.payment.repository;

import com.zee.modulith.payment.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 05 May, 2024
 */

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
