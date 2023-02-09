package com.singular.sportsbook.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.singular.sportsbook.dto.EventDescriptorDto;
import com.singular.sportsbook.dto.MarketDto;
import com.singular.sportsbook.dto.ParticipantDto;
import com.singular.sportsbook.dto.SelectionDto;
import com.singular.sportsbook.dto.SportsBookDto;
import com.singular.sportsbook.entity.EventDescriptor;
import com.singular.sportsbook.entity.Market;
import com.singular.sportsbook.entity.Participant;
import com.singular.sportsbook.entity.Selection;
import com.singular.sportsbook.entity.SportsBook;

public class SportsBookHelper {
  
  private SportsBookHelper() {}
  
  private static final String[] RESULT_TYPE = {"WIN", "DRAW", "LOSE"};
  
  public static SportsBook buildSportsBook(SportsBookDto sportsBookDto) {
    SportsBook sportsBook = SportsBook.builder()
        .id(sportsBookDto.getId())
    		.action(sportsBookDto.getAction())
    		.name(sportsBookDto.getName())
    		.scheduledStartTime(sportsBookDto.getSchedulingDto().getScheduledStartTime())
    		.bettingStatus(sportsBookDto.getBettingStatus())
    		.eventDescriptor(buildEventDescriptor(sportsBookDto.getEventDescriptorDto()))
    		.build();
    sportsBook.setMarkets(buildMarkets(sportsBookDto.getMarketsDto(), sportsBook));
    sportsBook.setParticipants(buildParticipants(sportsBookDto.getParticipantsDto(), sportsBook));
    return sportsBook;
  }
  
  public static SportsBookDto buildSportsBookDto(SportsBook sportsBook) {
	  return SportsBookDto.builder()
	      .id(sportsBook.getId())
	      .action(sportsBook.getAction())
	      .marketsDto(buildMarketDto(sportsBook.getMarkets()))
	      .build();
  }
  
  public static void updateSportsBook(SportsBookDto sportsBookDto, SportsBook sportsBook) {
    sportsBook.setAction(sportsBookDto.getAction() != null ? sportsBookDto.getAction() : sportsBook.getAction());
    sportsBook.setName(sportsBookDto.getName() != null ? sportsBookDto.getName() : sportsBook.getName());
    sportsBook.setBettingStatus(sportsBookDto.getBettingStatus() != null ? sportsBookDto.getBettingStatus() : sportsBook.getBettingStatus());
    
    List<MarketDto> marketsDto = sportsBookDto.getMarketsDto();
    List<Market> markets = sportsBook.getMarkets();
    marketsDto.stream().forEach(mDto -> {
      Market market = markets.stream().filter(m -> m.getId().equals(mDto.getId())).findFirst().get();
      market.setAction(mDto.getAction());
      market.setTypeId(mDto.getTypeId());
      market.setResulted(false);
      market.setName(mDto.getName());
      market.setBettingStatus(mDto.getBettingStatus());
      
      List<SelectionDto> selectionsDto = mDto.getSelectionsDto();
      List<Selection> selections = market.getSelections();
      selectionsDto.stream().forEach(sDto -> {
        Selection selection = selections.stream().filter(s -> s.getId().equals(sDto.getId())).findFirst().get();
        selection.setAction(sDto.getAction());
        selection.setName(sDto.getName());
        selection.setBettingStatus(sDto.getBettingStatus());
        selection.setPriceNumerator(sDto.getPriceNumerator());
        selection.setPriceDenominator(sDto.getPriceDenominator());
        selection.setCharacteristic(sDto.getCharacteristic());
      });
    });
  }
  
  private static EventDescriptor buildEventDescriptor(EventDescriptorDto eventDescriptorDto) {
    return EventDescriptor.builder()
        .leagueId(eventDescriptorDto.getLeagueId())
        .leagueName(eventDescriptorDto.getLeagueName())
        .sportId(eventDescriptorDto.getSportId())
        .sportName(eventDescriptorDto.getSportName())
        .build();
  }
  
  private static List<Market> buildMarkets(List<MarketDto> listMarketDto, SportsBook sportsBook) {
    List<Market> markets = new ArrayList<>();
    listMarketDto.stream().forEach(m -> {
      Market market = Market.builder()
          .id(m.getId())
          .action(m.getAction())
          .typeId(m.getTypeId())
          .resulted(false)
          .name(m.getName())
          .bettingStatus(m.getBettingStatus())
          .sportsBook(sportsBook)
          .build();
      market.setSelections(buildSelections(m.getSelectionsDto(), market));
      markets.add(market);
    });
    return markets;
  }

  private static List<Selection> buildSelections(List<SelectionDto> listSelectionDto, Market market) {
    List<Selection> selections = new ArrayList<>();
    listSelectionDto.stream().forEach(s -> {
      Selection selection = Selection.builder()
          .id(s.getId())
          .action(s.getAction())
          .name(s.getName())
          .displayOrder(s.getDisplayOrder())
          .bettingStatus(s.getBettingStatus())
          .priceNumerator(s.getPriceNumerator())
          .priceDenominator(s.getPriceDenominator())
          .characteristic(s.getCharacteristic())
          .market(market)
          .build();
      selections.add(selection);
    });
    return selections;
  }
  
  private static List<Participant> buildParticipants(List<ParticipantDto> listParticipantsDto, SportsBook sportsBook) {
    List<Participant> participants = new ArrayList<>();
    listParticipantsDto.stream().forEach(p -> {
      Participant participant = Participant.builder()
          .id(p.getId())
          .name(p.getName())
          .label(p.getLabel())
          .sportsBook(sportsBook)
          .build();
      participants.add(participant);
    });
    return participants;
  }
  
  private static List<MarketDto> buildMarketDto(List<Market> markets) {
    List<MarketDto> marketsDto = new ArrayList<>();
    markets.stream().forEach(m -> {
      MarketDto marketDto = MarketDto.builder()
          .id(m.getId())
          .action(m.getAction())
          .typeId(m.getTypeId())
          .resulted(true)
          .selectionsDto(buildSelectionDto(m.getSelections()))
          .build();
      marketsDto.add(marketDto);
    });
    return marketsDto;
  }
  
  private static List<SelectionDto> buildSelectionDto(List<Selection> selections) {
    List<SelectionDto> selectionsDto = new ArrayList<>();
    selections.stream().forEach(s -> {
      SelectionDto selectionDto = SelectionDto.builder()
          .id(s.getId())
          .action(s.getAction())
          .resultType(setResultType())
          .build();
      selectionsDto.add(selectionDto);
    });
    return selectionsDto;
  }
  
  private static String setResultType() {
    Random random = new Random();
    int index = random.nextInt(RESULT_TYPE.length);
    return RESULT_TYPE[index];
  }
  
}
