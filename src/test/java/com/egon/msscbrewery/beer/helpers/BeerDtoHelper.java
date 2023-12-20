package com.egon.msscbrewery.beer.helpers;

import com.egon.msscbrewery.beer.dtos.BeerDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

public class BeerDtoHelper {
  public static final UUID ID = UUID.fromString("aeb60d96-6aa1-4c2e-a82b-1683a7439d47");
  public static final String NAME = "Beer 1";
  public static final String STYLE = "Style 1";

  public static final Long UPC = 345678L;
  public static final OffsetDateTime CREATED_AT = OffsetDateTime.of(
      LocalDateTime.of(2023, 12, 19, 0, 0), ZoneOffset.UTC);

  public static final OffsetDateTime UPDATED_AT = OffsetDateTime.of(
      LocalDateTime.of(2023, 12, 20, 0, 0), ZoneOffset.UTC);

  public static final LocalDate DUE_DATE = LocalDate.now().plusYears(1);

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
        .upc(UPC)
        .createdAt(CREATED_AT)
        .updatedAt(UPDATED_AT)
        .dueDate(DUE_DATE);
  }
}
