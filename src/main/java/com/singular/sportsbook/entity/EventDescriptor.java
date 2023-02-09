package com.singular.sportsbook.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDescriptor {
  
  @Column(name = "league_id")
  private Integer leagueId;
  
  @Column(name = "league_name")
  private String leagueName;
  
  @Column(name = "sport_id")
  private Integer sportId;
  
  @Column(name = "sport_name")
  private String sportName;
  
}
