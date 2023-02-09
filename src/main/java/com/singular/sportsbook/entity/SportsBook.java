package com.singular.sportsbook.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sports_book")
public class SportsBook {
	
  @Id
  @Column(name = "id")
  private Long id;
  
  @Column(name = "action")
  private String action;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "scheduled_start_time")
  private Long scheduledStartTime;
  
  @Column(name = "betting_status")
  private String bettingStatus;
  
  @Embedded
  private EventDescriptor eventDescriptor;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "sportsBook", fetch = FetchType.EAGER)
  private List<Market> markets;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "sportsBook")
  private List<Participant> participants;
  
}
