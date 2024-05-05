package com.zee.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
class ApplicationTests {

    @Test
    void contextLoads() {
        ApplicationModules.of(Application.class).verify();
    }

}
