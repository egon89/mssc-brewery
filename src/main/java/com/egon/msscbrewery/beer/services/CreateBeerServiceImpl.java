package com.egon.msscbrewery.beer.services;

import com.egon.msscbrewery.beer.dtos.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateBeerServiceImpl implements CreateBeerService {
  @Override
  public BeerDto execute(BeerDto beer) {
    return BeerDto.builder()
        .id(UUID.randomUUID())
        .build();
  }
}
