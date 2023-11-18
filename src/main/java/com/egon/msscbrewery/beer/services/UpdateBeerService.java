package com.egon.msscbrewery.beer.services;

import com.egon.msscbrewery.beer.dtos.BeerDto;

import java.util.UUID;

public interface UpdateBeerService {
  BeerDto execute(UUID id, BeerDto beerDto);
}
