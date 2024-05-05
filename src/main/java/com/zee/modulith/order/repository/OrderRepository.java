package com.zee.modulith.order.repository;

import com.zee.modulith.order.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 05 May, 2024
 */

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
