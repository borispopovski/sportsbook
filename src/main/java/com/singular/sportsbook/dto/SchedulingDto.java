package com.singular.sportsbook.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonPropertyOrder({ "scheduledStartTime" })
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingDto {
  
  private Long scheduledStartTime;

}
