package com.zee.modulith.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 05 May, 2024
 */

@Repository
interface OrderRepository extends CrudRepository<Order, Long> {
}
