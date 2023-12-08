package com.egon.msscbrewery.customer.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class FindCustomerByIdServiceImplTest {

    @Autowired
    private FindCustomerByIdServiceImpl service;

    @Test
    void execute() {
        var expectedId = UUID.randomUUID();
        var result = service.execute(expectedId);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(expectedId);
    }

    @Test
    void shouldThrowErrorWhenDtoDoesNotHaveRequiredFields() {
        assertThrows(IllegalArgumentException.class, () -> service.execute(null));
    }
}