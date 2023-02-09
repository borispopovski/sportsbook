package com.singular.sportsbook.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonPropertyOrder({ "id", "name", "label" })
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto {

  private Long id;
  private String name;
  private String label;
  
}
