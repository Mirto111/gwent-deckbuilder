package org.myproject.deckbuilder.repository;

import java.util.List;

import org.myproject.deckbuilder.model.Deck;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DeckRepository extends MongoRepository<Deck,String> {

    List<Deck> findAllByUserId(String id);

}