package com.zee.modulith.inventory.setup;

import com.zee.modulith.inventory.Inventory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 05 May, 2024
 */

@Component
public class Setup implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Inventory inv1 = new Inventory();
        inv1.setName("pencil");
        inv1.setDescription("for drawing");
        inv1.setPrice(50000);
        inv1.setQuantity(3);

        Inventory inv2 = new Inventory();
        inv2.setName("ruler");
        inv2.setDescription("for drawing");
        inv2.setPrice(10000);
        inv2.setQuantity(3);

        Inventory inv3 = new Inventory();
        inv3.setName("book");
        inv3.setDescription("for drawing");
        inv3.setPrice(60000);
        inv3.setQuantity(3);

        Inventory inv4 = new Inventory();
        inv4.setName("drawing-pad");
        inv4.setDescription("for drawing");
        inv4.setPrice(70000);
        inv4.setQuantity(3);

        Inventory inv5 = new Inventory();
        inv5.setName("lunchbox");
        inv5.setDescription("for drawing");
        inv5.setPrice(80000);
        inv5.setQuantity(3);

        List<Inventory> inventoryList = List.of(inv1, inv2, inv3, inv4, inv5);

        //validate to avoid reentering

        //persist to database
    }
}
