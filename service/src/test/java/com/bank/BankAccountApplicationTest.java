package com.bank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@ActiveProfiles("test")
@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes = BankAccountApplication.class)
public class BankAccountApplicationTest {

    @Test
    public void uselessTest() {
        Assertions.assertThat(1).isEqualTo(1);
    }
}
