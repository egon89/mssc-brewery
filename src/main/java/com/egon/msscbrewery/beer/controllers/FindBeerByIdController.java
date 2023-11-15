package com.egon.msscbrewery.beer.controllers;

import com.egon.msscbrewery.beer.dtos.BeerDto;
import com.egon.msscbrewery.beer.services.FindBeerByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("api/v1/beers")
@RestController
@RequiredArgsConstructor
public class FindBeerByIdController {

  private final FindBeerByIdService findBeerByIdService;

  @GetMapping("/{id}")
  public ResponseEntity<BeerDto> findById(@PathVariable UUID id) {
    return new ResponseEntity<>(findBeerByIdService.execute(id), HttpStatus.OK);
  }
}
