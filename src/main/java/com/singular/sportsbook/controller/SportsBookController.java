package com.singular.sportsbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singular.sportsbook.dto.SportsBookDto;
import com.singular.sportsbook.service.ISportsBookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/sports")
public class SportsBookController {
  
  private ISportsBookService iSportsBookService;
  
  public SportsBookController(ISportsBookService iSportsBookService) {
    this.iSportsBookService = iSportsBookService;
  }
  
  @PostMapping("/create")
  public ResponseEntity<String> createSportsBook(@RequestBody SportsBookDto sportsBookDto) {
    log.info("Recieved sports_book {}", sportsBookDto);
    iSportsBookService.createSportsBook(sportsBookDto);
    return new ResponseEntity<>("The sportsbook is created", HttpStatus.OK);
  }
  
  @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SportsBookDto> getSportsBook(@PathVariable Long id) {
    log.info("Recieved id {}", id);
    return new ResponseEntity<>(iSportsBookService.getSportsBook(id), HttpStatus.OK);
  }
  
  @PutMapping("/update")
  public ResponseEntity<String> modigySportsBook(@RequestBody SportsBookDto sportsBookDto) {
    log.info("Recieved sports_book {}", sportsBookDto);
    iSportsBookService.modifySportsBook(sportsBookDto);
    return new ResponseEntity<>("The sportsbook is modified", HttpStatus.OK);
  }
  
}
