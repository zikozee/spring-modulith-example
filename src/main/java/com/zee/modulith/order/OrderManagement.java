package com.zee.modulith.order;

import com.zee.modulith.inventory.exposed.InventoryExposedService;
import com.zee.modulith.order.dto.OrderDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 06 May, 2024
 */

@Service
@RequiredArgsConstructor
public class OrderManagement {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final InventoryExposedService inventoryExposedService;

    @Transactional
    public void completeOrder(final OrderDto orderDto) {

        // get inventories
        // calculate price and total
        // save to orderRepo and OrderInventoryRepo
        // create dto to be pushed to payment listener
        // publish to payment listener (remember to use @ApplicationModuleListener)

    }
}
