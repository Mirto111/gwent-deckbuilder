package org.myproject.deckbuilder.controller;

import java.util.List;

import org.myproject.deckbuilder.model.Deck;
import org.myproject.deckbuilder.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/decks")
public class DeckController {

  private final DeckRepository deckRepository;

  @Autowired
  public DeckController(DeckRepository deckRepository) {
    this.deckRepository = deckRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
  public Deck get(@PathVariable("id") String id) {
    return deckRepository.findBy_id(id);
  }

  @GetMapping()
  public List<Deck> findAll() {
    return deckRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Deck create(@RequestBody Deck deck) {
    deckRepository.save(deck);
    return deck;
  }

  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable("id") String id) {
    deckRepository.deleteById(id);
  }

}
