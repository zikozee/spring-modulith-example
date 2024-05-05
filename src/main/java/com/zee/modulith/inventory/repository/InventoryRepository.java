package com.zee.modulith.inventory.repository;

import com.zee.modulith.inventory.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 05 May, 2024
 */

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
    Optional<Inventory> getInventoryByName(String inventoryName);

}
