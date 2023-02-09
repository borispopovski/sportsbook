package com.singular.sportsbook.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonPropertyOrder({ "leagueId", "leagueName", "sportId", "sportName" })
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDescriptorDto {
  
  private Integer leagueId;
  private String leagueName;
  private Integer sportId;
  private String sportName;

}
