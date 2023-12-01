package com.egon.msscbrewery.beer.controllers;

import com.egon.msscbrewery.beer.dtos.BeerDto;
import com.egon.msscbrewery.beer.helpers.BeerDtoHelper;
import com.egon.msscbrewery.beer.services.CreateBeerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
 * @WebMvcTest
 * Spring Boot instantiates only the web layer rather than the whole context.
 */
@WebMvcTest(CreateBeerController.class)
class CreateBeerControllerTest {

  @MockBean
  CreateBeerService service;

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  void shouldCreateBeer() throws Exception {
    var beerDto = BeerDtoHelper.createWithoutId();
    var beerDtoJson = objectMapper.writeValueAsString(beerDto);
    var beerDtoSaved = BeerDtoHelper.create();
    given(service.execute(any())).willReturn(beerDtoSaved);

    mockMvc.perform(post("/api/v1/beers")
        .contentType(MediaType.APPLICATION_JSON)
        .content(beerDtoJson))
        .andExpect(status().isCreated());
    verify(service, times(1)).execute(beerDto);
  }

  /*
  * spring-boot-starter-test already has the junit-jupiter-params artifact
  */
  @ParameterizedTest
  @MethodSource("provideInvalidFields")
  void shouldReturnBadRequestErrorWhenFieldsAreInvalid(BeerDto beerDto) throws Exception {
    var beerDtoJson = objectMapper.writeValueAsString(beerDto);

    mockMvc.perform(post("/api/v1/beers")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(beerDtoJson))
            .andExpect(status().isUnprocessableEntity());
    verify(service, never()).execute(any());
  }

  private static Stream<Arguments> provideInvalidFields() {
    return Stream.of(
            Arguments.of(BeerDto.builder().name(null).style("style").upc(1L).build()),
            Arguments.of(BeerDto.builder().name("").style("style").upc(1L).build()),
            Arguments.of(BeerDto.builder().name("name").style(null).upc(1L).build()),
            Arguments.of(BeerDto.builder().name("name").style("").upc(1L).build()),
            Arguments.of(BeerDto.builder().name("name").style("style").upc(null).build()),
            Arguments.of(BeerDto.builder().name("name").style("style").upc(Long.MIN_VALUE).build()),
            Arguments.of(BeerDto.builder().name("name").style("style").upc(0L).build()),
            Arguments.of(BeerDto.builder().build()));
  }
}