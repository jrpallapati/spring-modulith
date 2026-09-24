package org.pallapati.spring.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class SpringModulithApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void verifiesModularStructure() {
        ApplicationModules.of(SpringModulithApplication.class).verify();
    }

}
