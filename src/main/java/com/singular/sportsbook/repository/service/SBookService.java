package com.singular.sportsbook.repository.service;

import org.springframework.stereotype.Service;

import com.singular.sportsbook.entity.SportsBook;
import com.singular.sportsbook.exception.SportsBookNotFoundException;
import com.singular.sportsbook.repository.SportsBookRepository;

@Service
public class SBookService {
  
  private SportsBookRepository repository;
  
  public SBookService(SportsBookRepository repository) {
    this.repository = repository;
  }
  
  public void saveSportsBook(SportsBook sportsBook) {
    repository.save(sportsBook);
  }
  
  public SportsBook getSportsBook(Long id) {
    return repository.findById(id).orElseThrow(() -> new SportsBookNotFoundException());
  }
  
}
