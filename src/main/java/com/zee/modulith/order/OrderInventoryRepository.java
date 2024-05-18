package com.zee.modulith.order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 05 May, 2024
 */

@Repository
interface OrderInventoryRepository extends CrudRepository<OrderInventory, Long> {

    @Query(value = "SELECT SUM(order_inventory.total_qty_price) from order_inventory where order_id = ?1", nativeQuery = true)
    long orderIdAmount(long orderId);
}
