package com.zee.modulith.inventory.exposed;

import com.zee.modulith.inventory.Inventory;
import com.zee.modulith.inventory.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 06 May, 2024
 */

@Service
@RequiredArgsConstructor
public class InventoryExposedService {

    private final InventoryRepository repository;

    public Optional<Inventory> fetchInventoryByName(String name) {
        return repository.getInventoryByName(name);
    }
}
