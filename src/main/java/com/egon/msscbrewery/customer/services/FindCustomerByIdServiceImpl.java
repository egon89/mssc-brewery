package com.egon.msscbrewery.customer.services;

import com.egon.msscbrewery.customer.dtos.CustomerDto;
import com.egon.msscbrewery.customer.entities.CustomerEntity;
import com.egon.msscbrewery.customer.mappers.CustomerMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindCustomerByIdServiceImpl implements FindCustomerByIdService {

  private final CustomerMapper mapper;

  @Override
  public CustomerDto execute(@NonNull UUID id) {
    val customer = CustomerEntity.builder()
            .id(id)
            .name("Customer 1")
            .build();

    return mapper.toDto(customer);
  }
}
