package com.singular.sportsbook.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonPropertyOrder({ "id", "action", "typeId", "resulted", "name", "bettingStatus", "selectionsDto" })
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarketDto {

  private Long id;
  private String action;
  private Integer typeId;
  
  @JsonProperty(access = Access.READ_ONLY)
  private boolean resulted;

  @JsonProperty(access = Access.WRITE_ONLY)
  private String name;

  @JsonProperty(access = Access.WRITE_ONLY)
  private String bettingStatus;

  @JsonProperty("selections")
  private List<SelectionDto> selectionsDto;

}
