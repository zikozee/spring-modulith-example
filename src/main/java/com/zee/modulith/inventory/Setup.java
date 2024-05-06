package com.zee.modulith.inventory;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 05 May, 2024
 */

@Component
@RequiredArgsConstructor
class Setup implements CommandLineRunner {
    private final InventoryRepository repository;

    @Override
    public void run(String... args) throws Exception {

        Inventory inv1 = new Inventory();
        inv1.setName("pencil");
        inv1.setDescription("for writing");
        inv1.setPrice(50000);
        inv1.setQuantity(3);

        Inventory inv2 = new Inventory();
        inv2.setName("ruler");
        inv2.setDescription("for ruling");
        inv2.setPrice(10000);
        inv2.setQuantity(2);

        Inventory inv3 = new Inventory();
        inv3.setName("book");
        inv3.setDescription("for taking notes");
        inv3.setPrice(60000);
        inv3.setQuantity(3);

        Inventory inv4 = new Inventory();
        inv4.setName("drawing_pad");
        inv4.setDescription("for drawing");
        inv4.setPrice(70000);
        inv4.setQuantity(1);

        Inventory inv5 = new Inventory();
        inv5.setName("lunchbox");
        inv5.setDescription("for packing lunch");
        inv5.setPrice(80000);
        inv5.setQuantity(2);

        List<Inventory> inventoryList = List.of(inv1, inv2, inv3, inv4, inv5);
        List<Inventory> inventories = new ArrayList<>();

        //validate to avoid reentering
        inventoryList
                .forEach(inventory -> {
                    if(repository.getInventoryByName(inventory.getName()).isEmpty())
                        inventories.add(inventory);
                });

        //persist to database
        if(!inventories.isEmpty()) repository.saveAll(inventories);
    }
}
