package org.myproject.deckbuilder.repository;

import org.myproject.deckbuilder.model.Deck;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DeckRepository extends MongoRepository<Deck,String> {

    Deck findBy_id(String _id);

}