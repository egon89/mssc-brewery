package com.egon.msscbrewery.beer.controllers;

import com.egon.msscbrewery.beer.dtos.BeerDto;
import com.egon.msscbrewery.beer.services.UpdateBeerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/beers")
@RequiredArgsConstructor
public class UpdateBeerController {

  private final UpdateBeerService updateBeerService;

  /*
   * We can use a void method with the response status annotation
   * instead of returning a ResponseEntity
   */
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateBeer(@PathVariable UUID id, @Valid @RequestBody BeerDto beerDto) {
    updateBeerService.execute(id, beerDto);
  }
}
