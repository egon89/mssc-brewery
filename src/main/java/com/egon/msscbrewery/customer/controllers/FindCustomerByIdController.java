package com.egon.msscbrewery.customer.controllers;

import com.egon.msscbrewery.customer.dtos.CustomerDto;
import com.egon.msscbrewery.customer.services.FindCustomerByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class FindCustomerByIdController {

  private final FindCustomerByIdService findCustomerByIdService;

  @GetMapping("/{id}")
  public ResponseEntity<CustomerDto> findCustomerById(@PathVariable UUID id) {
    return new ResponseEntity<>(findCustomerByIdService.execute(id), HttpStatus.OK);
  }
}
