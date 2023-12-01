package com.egon.msscbrewery.beer.controllers;

import com.egon.msscbrewery.beer.dtos.BeerDto;
import com.egon.msscbrewery.beer.services.CreateBeerService;
import com.egon.msscbrewery.shared.dtos.ValidationErrorDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static com.egon.msscbrewery.shared.utils.ErrorUtil.getFieldErrors;
import static com.egon.msscbrewery.shared.utils.ErrorUtil.validationErrorFactory;

@RestController
@RequestMapping("api/v1/beers")
@RequiredArgsConstructor
public class CreateBeerController {

  private final CreateBeerService createBeerService;

  @PostMapping
  public ResponseEntity<Void> createBeer(@Valid @RequestBody BeerDto beerDto) {
    var beerCreatedDto = createBeerService.execute(beerDto);

    // TODO add domain
    return ResponseEntity.created(
        URI.create("/api/v1/beers/".concat(beerCreatedDto.getId().toString())))
        .build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationErrorDto> CreateBeerCustomErrorHandler(MethodArgumentNotValidException e) {
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
              validationErrorFactory(getFieldErrors(e)));
  }
}
