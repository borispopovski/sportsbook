package com.singular.sportsbook.service;

import com.singular.sportsbook.dto.SportsBookDto;

public interface ISportsBookService {
  void createSportsBook(SportsBookDto sportsBookDto);
  SportsBookDto getSportsBook(Long id);
  void modifySportsBook(SportsBookDto sportsBookDto);
}
