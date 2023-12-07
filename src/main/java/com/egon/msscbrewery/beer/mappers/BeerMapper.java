package com.egon.msscbrewery.beer.mappers;

import com.egon.msscbrewery.beer.dtos.BeerDto;
import com.egon.msscbrewery.beer.entities.BeerEntity;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDto toDto(BeerEntity entity);
    BeerEntity toEntity(BeerDto dto);
}
