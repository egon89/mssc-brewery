package com.egon.msscbrewery.customer.services;

import com.egon.msscbrewery.customer.dtos.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindCustomerByIdServiceImpl implements FindCustomerByIdService {
  @Override
  public CustomerDto execute(UUID id) {
    return CustomerDto.builder()
        .id(UUID.randomUUID())
        .name("Customer 1")
        .build();
  }
}
