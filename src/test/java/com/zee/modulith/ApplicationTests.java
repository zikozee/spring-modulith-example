package com.zee.modulith;

import com.zee.modulith.order.Order;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
class ApplicationTests {

    @Test
    void contextLoads() {
        ApplicationModules.of(Application.class).verify();
    }



}
