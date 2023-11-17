package com.egon.msscbrewery.beer.controllers;

import com.egon.msscbrewery.beer.dtos.BeerDto;
import com.egon.msscbrewery.beer.services.CreateBeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("api/v1/beers")
@RequiredArgsConstructor
public class CreateBeerController {

  private final CreateBeerService createBeerService;

  @PostMapping
  public ResponseEntity<Void> createBeer(@RequestBody BeerDto beerDto) {
    var beerCreatedDto = createBeerService.execute(beerDto);

    // TODO add domain
    return ResponseEntity.created(
        URI.create("/api/v1/beers/".concat(beerCreatedDto.getId().toString())))
        .build();
  }
}
