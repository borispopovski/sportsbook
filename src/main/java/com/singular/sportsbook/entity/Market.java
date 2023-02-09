package com.singular.sportsbook.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "market")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Market {

  @Id
  @Column(name = "id")
  private Long id;
  
  @Column(name = "action")
  private String action;
  
  @Column(name = "type_id")
  private Integer typeId;
  
  @Column(name = "resulted")
  private boolean resulted;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "betting_status")
  private String bettingStatus;
  
  @ManyToOne
  @JoinColumn(columnDefinition = "sports_book_id", referencedColumnName = "id")
  private SportsBook sportsBook;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "market")
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Selection> selections;
  
}
