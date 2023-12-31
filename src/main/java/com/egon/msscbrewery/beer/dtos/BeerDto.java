package com.egon.msscbrewery.beer.dtos;

import com.egon.msscbrewery.shared.annotations.JsonBasicLocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

  private UUID id;

  @NotBlank
  private String name;

  @NotBlank
  private String style;

  @NotNull
  @Positive
  private Long upc;

  private OffsetDateTime createdAt;

  private OffsetDateTime updatedAt;

  @JsonBasicLocalDate
  private LocalDate dueDate;
}
