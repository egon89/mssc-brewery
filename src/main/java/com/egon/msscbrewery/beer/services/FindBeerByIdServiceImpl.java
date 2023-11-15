package com.egon.msscbrewery.beer.services;

import com.egon.msscbrewery.beer.dtos.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindBeerByIdServiceImpl implements FindBeerByIdService {
  @Override
  public BeerDto execute(UUID id) {
    return BeerDto.builder().id(UUID.randomUUID())
        .name("Galaxy Cat")
        .style("Pale Ale")
        .build();
  }
}
