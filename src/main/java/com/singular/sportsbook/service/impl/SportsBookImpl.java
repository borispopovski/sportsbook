package com.singular.sportsbook.service.impl;

import org.springframework.stereotype.Service;

import com.singular.sportsbook.dto.SportsBookDto;
import com.singular.sportsbook.entity.SportsBook;
import com.singular.sportsbook.helper.SportsBookHelper;
import com.singular.sportsbook.repository.service.SBookService;
import com.singular.sportsbook.service.ISportsBookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SportsBookImpl implements ISportsBookService {
  
  private SBookService sBookService;
  
  public SportsBookImpl(SBookService sportsBookService) {
    this.sBookService = sportsBookService; 
  }

  @Override
  public void createSportsBook(SportsBookDto sportsBookDto) {
    try {
      SportsBook sportsBook = SportsBookHelper.buildSportsBook(sportsBookDto);
      sBookService.saveSportsBook(sportsBook);
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }

  @Override
  public SportsBookDto getSportsBook(Long id) {
    SportsBookDto sportsBookDto = null;
    try {
      SportsBook sportsBook = sBookService.getSportsBook(id);
      sportsBookDto = SportsBookHelper.buildSportsBookDto(sportsBook);
    } catch (Exception e) {
      log.error(e.getMessage());
    }
    return sportsBookDto;
  }

  @Override
  public void modifySportsBook(SportsBookDto sportsBookDto) {
    try {
      SportsBook sportsBook = sBookService.getSportsBook(sportsBookDto.getId());
      SportsBookHelper.updateSportsBook(sportsBookDto, sportsBook);
      sBookService.saveSportsBook(sportsBook);
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }

}
