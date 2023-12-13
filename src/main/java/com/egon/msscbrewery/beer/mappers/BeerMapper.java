package com.egon.msscbrewery.beer.mappers;

import com.egon.msscbrewery.beer.dtos.BeerDto;
import com.egon.msscbrewery.beer.entities.BeerEntity;
import com.egon.msscbrewery.shared.mappers.DateMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto toDto(BeerEntity entity);
    BeerEntity toEntity(BeerDto dto);
}
