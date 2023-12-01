package com.egon.msscbrewery.shared.dtos;

import java.util.List;

public record ValidationErrorDto(String message, List<String> errors) {}
