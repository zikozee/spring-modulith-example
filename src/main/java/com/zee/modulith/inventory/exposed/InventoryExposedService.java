package com.zee.modulith.inventory.exposed;

import com.zee.modulith.exception.ModulithException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 06 May, 2024
 */

@Service
@RequiredArgsConstructor
public class InventoryExposedService {

    private final InventoryRepository repository;

    public Inventory fetchInventoryByName(String name) {
        return repository.getInventoryByName(name)
                .orElseThrow(ModulithException::new);
    }

    public List<Inventory> fetchAllInName(List<String> inventoryNames) {
        return repository.getInventoryByNameIn(inventoryNames);
    }
}
