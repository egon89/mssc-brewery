package com.egon.msscbrewery.shared.handlers;

import com.egon.msscbrewery.shared.dtos.ValidationErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.egon.msscbrewery.shared.utils.ErrorUtil.getFieldErrors;
import static com.egon.msscbrewery.shared.utils.ErrorUtil.validationErrorFactory;

// @RestControllerAdvice: handle any kind of exception using a centralized way
@RestControllerAdvice
public class BreweryExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorDto> handleError(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                validationErrorFactory(getFieldErrors(e)));
    }
}
