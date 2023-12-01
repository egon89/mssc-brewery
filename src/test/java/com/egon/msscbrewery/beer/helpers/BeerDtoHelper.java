package com.egon.msscbrewery.beer.helpers;

import com.egon.msscbrewery.beer.dtos.BeerDto;

import java.util.UUID;

public class BeerDtoHelper {
  public static final UUID ID = UUID.fromString("aeb60d96-6aa1-4c2e-a82b-1683a7439d47");
  public static final String NAME = "Beer 1";
  public static final String STYLE = "Style 1";

  public static final Long UPC = 345678L;

  public static BeerDto create() {
    return beerDtoBuilder().build();
  }

  public static BeerDto createWithId(UUID id) {
    return beerDtoBuilder()
        .id(id)
        .build();
  }

  public static BeerDto createWithoutId() {
    return beerDtoBuilder()
        .id(null)
        .build();
  }

  private static BeerDto.BeerDtoBuilder beerDtoBuilder() {
    return BeerDto.builder()
        .id(ID)
        .name(NAME)
        .style(STYLE)
        .upc(UPC);
  }
}
