package org.myproject.deckbuilder.controller;

import java.util.List;
import org.myproject.deckbuilder.model.Card;
import org.myproject.deckbuilder.model.Faction;
import org.myproject.deckbuilder.model.CardType;
import org.myproject.deckbuilder.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/cards")
public class CardController {

  private final CardRepository crudRepository;

  @Autowired
  public CardController(CardRepository crudRepository) {
    this.crudRepository = crudRepository;
  }

  @GetMapping()
  public List<Card> findAll() {
    return crudRepository.findAll();
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
  public Card get(@PathVariable("id") int id) {
    return crudRepository.findById(id).orElseThrow(IllegalArgumentException::new);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "faction/{faction}")
  public List<Card> findByFaction(@PathVariable("faction") Faction faction) {
    return crudRepository.findByFaction(faction);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/leaders")
  public List<Card> findAllLeaders() {
    return crudRepository.findByCardType(CardType.Leader);
  }

}
