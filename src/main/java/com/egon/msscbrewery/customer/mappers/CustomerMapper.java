package com.egon.msscbrewery.customer.mappers;

import com.egon.msscbrewery.customer.dtos.CustomerDto;
import com.egon.msscbrewery.customer.entities.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto toDto(CustomerEntity entity);
    CustomerEntity toEntity(CustomerDto dto);
}
