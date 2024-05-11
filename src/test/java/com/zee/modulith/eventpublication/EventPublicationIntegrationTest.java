package com.zee.modulith.eventpublication;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ApplicationModuleTest(mode = ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES)
class EventPublicationIntegrationTest {

    @Autowired
    CustomEventPublicationService customEventPublicationService;

    @Order(1)
    @Test
    void verifyOrderModule() {

    }

    @Test
    void getUncompletedEventPublications() {

        List<CustomEventPublication> uncompletedEventPublications = customEventPublicationService.getUncompletedEventPublications();

        uncompletedEventPublications
                .forEach(event -> {
                    assertThat(event).isInstanceOf(CustomEventPublication.class);
                    assertThat(event.getCompletionDate()).isNull();
                });
    }

    @Test
    void getCompletedEventPublications() {
        List<CustomEventPublication> uncompletedEventPublications = customEventPublicationService.getCompletedEventPublications();

        assertThat(uncompletedEventPublications).isNotEmpty();
        assertThat(uncompletedEventPublications.getFirst().getPublicationDate()).isNotNull();

        uncompletedEventPublications
                .forEach(event -> {
                    assertThat(event).isInstanceOf(CustomEventPublication.class);
                    assertThat(event.getCompletionDate()).isNotNull();
                });
    }
}