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
@Table(name = "participant")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Participant {

  @Id
  @Column(name = "id")
  private Long id;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "label")
  private String label;
  
  @ManyToOne
  @JoinColumn(columnDefinition = "sports_book_id", referencedColumnName = "id")
  private SportsBook sportsBook;
  
}
