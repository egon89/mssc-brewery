package com.egon.msscbrewery.customer.services;

import com.egon.msscbrewery.customer.dtos.CustomerDto;

import java.util.UUID;

public interface FindCustomerByIdService {
  CustomerDto execute(UUID id);
}
