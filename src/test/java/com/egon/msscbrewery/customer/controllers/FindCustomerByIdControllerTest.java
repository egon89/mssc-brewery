package com.egon.msscbrewery.customer.controllers;

import com.egon.msscbrewery.customer.helpers.CustomerDtoHelper;
import com.egon.msscbrewery.customer.services.FindCustomerByIdService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FindCustomerByIdController.class)
class FindCustomerByIdControllerTest {
  @MockBean
  FindCustomerByIdService service;

  @Autowired
  MockMvc mockMvc;

  @Test
  void shouldFindById() throws Exception {
    var customerDto = CustomerDtoHelper.create();
    given(service.execute(any())).willReturn(customerDto);

    mockMvc.perform(get("/api/v1/customers/".concat(CustomerDtoHelper.ID.toString())))
        .andExpectAll(
            status().isOk(),
            jsonPath("$.id").value(customerDto.getId().toString()),
            jsonPath("$.name").value(customerDto.getName()));
    verify(service).execute(CustomerDtoHelper.ID);
  }
}