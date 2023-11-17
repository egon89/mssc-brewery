package com.egon.msscbrewery.beer.services;

import com.egon.msscbrewery.beer.dtos.BeerDto;

public interface CreateBeerService {
  BeerDto execute(BeerDto beer);
}
