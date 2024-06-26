package com.zee.modulith.order;

import com.zee.modulith.order.dto.InventoryDto;
import com.zee.modulith.order.dto.OrderDto;
import com.zee.modulith.order.dto.PaymentDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ApplicationModuleTest(mode = ApplicationModuleTest.BootstrapMode.ALL_DEPENDENCIES)
class OrderIntegrationTest {

//    @MockBean
//    InventoryExposedService exposedService;
    @Autowired
    OrderService orderService;

    @Test
    void verifyOrderModule() {

    }

    static LocalDateTime date;

    @BeforeAll
    static void beforeAll() {
        date = LocalDateTime.now();
        System.out.println(date);
    }

    @Test
    void testMakeOrder(Scenario scenario) throws InterruptedException {
        List<InventoryDto> inventoryDtos = List.of(
                new InventoryDto("pencil", 5),
                new InventoryDto("ruler", 3),
                new InventoryDto("book", 4)
        );

        OrderDto initOrderDto = new OrderDto(
                "Ezekiel",
                "test@test.com",
                inventoryDtos,
                null, null, null);

        long expectedAmount = (5 * 50000) + (3 * 10000) + (4 * 60000);
        System.out.println("Expected amount " + expectedAmount);

        scenario.stimulate(() ->  orderService.makeOrder(initOrderDto))
                .andWaitForEventOfType(PaymentDto.class)
                .matching(event -> event.amount() == expectedAmount)
                .toArriveAndVerify(event -> System.out.println(event.amount()));
//        OrderDto orderDto = orderService.makeOrder(initOrderDto);
//        PaymentDto paymentDto = orderDto.paymentDto();
//
//        assertNotNull(paymentDto);
//        assertEquals(expectedAmount, paymentDto.amount());
//
//        scenario.publish(paymentDto)
//                .andWaitForEventOfType(PaymentDto.class)
//                .matching(event -> event.amount() == expectedAmount)
//                .toArriveAndVerify(event -> System.out.println(event.amount()));

    }

    @Test
    void publishPaymentDtoTest(Scenario scenario) throws InterruptedException {

        scenario.publish(new PaymentDto(UUID.randomUUID().toString(), 6500000L))
                        .andWaitForEventOfType(PaymentDto.class)
                        .matching(event -> event.amount() == 6500000L)
                        .toArriveAndVerify(event -> System.out.println(event.amount()));
    }
}