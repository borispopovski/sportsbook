package com.singular.sportsbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SportsBookNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 6874034096300487382L;
  
  public SportsBookNotFoundException() {
    super("Sportsbook not found!");
  }

}
