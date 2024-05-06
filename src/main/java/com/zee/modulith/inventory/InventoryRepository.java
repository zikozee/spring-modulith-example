package com.zee.modulith.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 05 May, 2024
 */

@Repository
interface InventoryRepository extends CrudRepository<Inventory, Long> {
    Optional<Inventory> getInventoryByName(String inventoryName);

}
