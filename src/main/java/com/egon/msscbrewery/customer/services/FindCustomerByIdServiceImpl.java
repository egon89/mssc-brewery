package com.egon.msscbrewery.customer.services;

import com.egon.msscbrewery.customer.dtos.CustomerDto;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindCustomerByIdServiceImpl implements FindCustomerByIdService {
  @Override
  public CustomerDto execute(@NonNull UUID id) {
    return CustomerDto.builder()
        .id(id)
        .name("Customer 1")
        .build();
  }
}
