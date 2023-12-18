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

@ActiveProfiles("snake")
@JsonTest
class BeerDtoSnakeTest {
  public static final String JSON_VALUE = "{\"id\":\"aeb60d96-6aa1-4c2e-a82b-1683a7439d47\",\"name\":\"Beer 1\",\"style\":\"Style 1\",\"upc\":345678,\"created_at\":null,\"updated_at\":null}";
  @Autowired
  ObjectMapper objectMapper;

  @Test
  void shouldSerialize() throws JsonProcessingException {
    val dto = BeerDtoHelper.create();

    val result = objectMapper.writeValueAsString(dto);

    assertThat(result).isEqualTo(JSON_VALUE);
  }

  @Test
  void shouldDeserialize() throws JsonProcessingException {
    val expected = BeerDtoHelper.create();

    val result = objectMapper.readValue(JSON_VALUE, BeerDto.class);

    assertThat(result).isEqualTo(expected);
  }
}