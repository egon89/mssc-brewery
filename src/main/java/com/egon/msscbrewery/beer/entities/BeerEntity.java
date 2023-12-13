package com.egon.msscbrewery.beer.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerEntity {
    private UUID id;
    private String name;
    private String style;
    private Long upc;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
