package com.singular.sportsbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "selection")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Selection {

  @Id
  @Column(name = "id")
  private Long id;
  
  @Column(name = "action")
  private String action;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "display_order")
  private Integer displayOrder;
  
  @Column(name = "betting_status")
  private String bettingStatus;
  
  @Column(name = "price_numerator")
  private Integer priceNumerator;
  
  @Column(name = "price_denominator")
  private Integer priceDenominator;
  
  @Column(name = "characteristic")
  private String characteristic;
  
  @ManyToOne
  @JoinColumn(columnDefinition = "market_id", referencedColumnName = "id")
  private Market market;
  
}
