package com.egon.msscbrewery.customer.helpers;

import com.egon.msscbrewery.customer.dtos.CustomerDto;

import java.util.UUID;

public class CustomerDtoHelper {
  public static final UUID ID = UUID.fromString("2bc80df0-f36d-40dd-b3b5-c4d8571eb713");
  public static final String NAME = "Customer 1";


  public static CustomerDto create() {
    return CustomerDto.builder()
        .id(ID)
        .name(NAME)
        .build();
  }
}
