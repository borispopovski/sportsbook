package com.singular.sportsbook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonPropertyOrder({ "id", "action", "name", "displayOrder", "bettingStatus", "priceNumerator", "priceDenominator",
    "characteristic" })
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SelectionDto {

  private Long id;
  private String action;
  
  @JsonProperty(access = Access.WRITE_ONLY)
  private String name;
  
  @JsonProperty(access = Access.WRITE_ONLY)
  private Integer displayOrder;
  
  @JsonProperty(access = Access.WRITE_ONLY)
  private String bettingStatus;
  
  @JsonProperty(access = Access.WRITE_ONLY)
  private Integer priceNumerator;
  
  @JsonProperty(access = Access.WRITE_ONLY)
  private Integer priceDenominator;
  
  @JsonProperty(access = Access.WRITE_ONLY)
  private String characteristic;
  
  private String resultType;

}
