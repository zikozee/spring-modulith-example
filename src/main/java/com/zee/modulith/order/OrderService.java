package com.zee.modulith.order;

import com.zee.modulith.inventory.exposed.Inventory;
import com.zee.modulith.inventory.exposed.InventoryExposedService;
import com.zee.modulith.order.dto.*;
import com.zee.modulith.order.type.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 06 May, 2024
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderInventoryRepository orderInventoryRepository;
    private final InventoryExposedService inventoryExposedService;
    private final OrderManagement management;

    public OrderDto makeOrder(OrderDto orderDto) {

        // get inventories
        List<String> inventoryNames = orderDto
                .inventories().stream()
                .map(InventoryDto::inventoryName)
                .toList();

        List<Inventory> inventories = inventoryExposedService
                .fetchAllInName(inventoryNames);

        AtomicLong amount = new AtomicLong(0L);
        Order order = buildAndPersistOrder(orderDto);
        log.info("Order created: {}", order);
        buildAndPersistOrderInventories(orderDto, inventories, order.getId(), amount);

        PaymentDto paymentDto  = new PaymentDto(order.getOrderIdentifier(), amount.get());
        log.info("Payment {}", paymentDto);
        EmailDto emailDto = new EmailDto(orderDto.customerEmail(), orderDto.customerName(), order.getOrderIdentifier(), paymentDto.amount(), false);
        management.completeOrder(paymentDto, emailDto);
        return new OrderDto("Order Currently Processing", 102, paymentDto);
    }

    public CompleteOrder completePayment(final CompleteOrder completeOrder) {
        Optional<Order> optionalOrder = orderRepository.findOrderByOrderIdentifier(completeOrder.orderIdentifier());
        if (optionalOrder.isEmpty()) throw new RuntimeException("Order not found");
        Order order = optionalOrder.get();

        final long amount = orderInventoryRepository.orderIdAmount(order.getId());
        EmailDto emailDto = new EmailDto(order.getCustomerEmail(), order.getCustomerName(),
                order.getOrderIdentifier(), amount, true);
        management.completePayment(completeOrder, emailDto);
        return new CompleteOrder(null, true);
    }


    private void buildAndPersistOrderInventories(OrderDto orderDto, List<Inventory> inventories, long orderId, AtomicLong amount) {
        List<OrderInventory> orderInventories = new ArrayList<>(inventories.size());

        inventories.forEach(inventory -> {
            OrderInventory orderInventory = new OrderInventory();

            InventoryDto inventoryDto = getInventoryDtoByName(inventory.getName(), orderDto.inventories());
            orderInventory.setOrderId(orderId);
            orderInventory.setInventoryId(inventory.getId());
            orderInventory.setQty(inventoryDto.qty());

            long totalPrice = inventory.getPrice() * inventoryDto.qty();
            orderInventory.setTotalQtyPrice(totalPrice);

            orderInventories.add(orderInventory);
            amount.addAndGet(totalPrice);
        });

        log.info("Order inventory persisted: {}", orderInventories);
        orderInventoryRepository.saveAll(orderInventories);
    }


    private Order buildAndPersistOrder(OrderDto orderDto) {
        final String orderIdentifier = UUID.randomUUID().toString();

        Order order = new Order();
        order.setOrderIdentifier(orderIdentifier);
        order.setCustomerName(orderDto.customerName());
        order.setCustomerEmail(orderDto.customerEmail());
        order.setStatus(Status.COMPLETED);
        return orderRepository.save(order);
    }


    private static InventoryDto getInventoryDtoByName(String inventoryName, List<InventoryDto> inventoryDtos) {
        return inventoryDtos
                .stream()
                .filter(inv -> inv.inventoryName().equalsIgnoreCase(inventoryName))
                .findFirst().orElse(null);
    }
}
