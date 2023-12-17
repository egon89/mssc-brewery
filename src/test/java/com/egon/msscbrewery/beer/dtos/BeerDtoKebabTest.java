package com.egon.msscbrewery.beer.dtos;

import com.egon.msscbrewery.beer.helpers.BeerDtoHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("kebab")
@JsonTest
class BeerDtoKebabTest {
  @Autowired
  ObjectMapper objectMapper;

  @Test
  void shouldSerialize() throws JsonProcessingException {
    val dto = BeerDtoHelper.create();
    val expected = "{\"id\":\"aeb60d96-6aa1-4c2e-a82b-1683a7439d47\",\"name\":\"Beer 1\",\"style\":\"Style 1\",\"upc\":345678,\"created-at\":null,\"updated-at\":null}";

    val result = objectMapper.writeValueAsString(dto);

    assertThat(result).isEqualTo(expected);
  }
}