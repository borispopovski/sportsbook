package com.singular.sportsbook.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonPropertyOrder({ "id", "action", "name", "scheduledStartTime", "bettingStatus", "marketsDto", "eventDescriptorDto",
    "participantsDto", "schedulingDto" })
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SportsBookDto {

  private Long id;
  private String action;
  
  @JsonProperty(access = Access.WRITE_ONLY)
  private String name;
  
  @JsonProperty(access = Access.WRITE_ONLY)
  private String bettingStatus;
  
  @JsonProperty("markets")
  private List<MarketDto> marketsDto;
  
  @JsonProperty(value = "eventDescriptor", access = Access.WRITE_ONLY)
  private EventDescriptorDto eventDescriptorDto;
  
  @JsonProperty(value = "participants", access = Access.WRITE_ONLY)
  private List<ParticipantDto> participantsDto;
  
  @JsonProperty(value = "scheduling", access = Access.WRITE_ONLY)
  private SchedulingDto schedulingDto;
  
}
