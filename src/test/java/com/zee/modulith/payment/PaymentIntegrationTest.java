package com.zee.modulith.payment;

import com.zee.modulith.order.dto.PaymentDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.AssertablePublishedEvents;
import org.springframework.modulith.test.PublishedEvents;
import org.springframework.modulith.test.Scenario;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest
class PaymentIntegrationTest {

    @Autowired
    PaymentManagement paymentManagement;

    static LocalDateTime date;

    @BeforeAll
    static void beforeAll() {
        date =  LocalDateTime.now();
    }

    @Test
    void verifyPaymentModule() {

    }


    @Order(2)
    @Test
    void testPublishedEvent(PublishedEvents events){

        PublishedEvents.TypedPublishedEvents<PaymentDto> matching = events.ofType(PaymentDto.class);

        assertThat(matching).isNotNull();
    }

//    @Test
//    void assertPublishedEvents(AssertablePublishedEvents events) {
//        String uniqueKey = "abcdefghij" + date;
//        assertThat(events)
//                .contains(PaymentDto.class)
//                .matching(ev -> ev.orderId().equalsIgnoreCase(uniqueKey));
//    }
}