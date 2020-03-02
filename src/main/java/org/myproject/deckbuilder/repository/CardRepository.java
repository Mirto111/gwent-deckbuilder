package org.myproject.deckbuilder.repository;

import java.util.List;
import org.myproject.deckbuilder.model.Card;
import org.myproject.deckbuilder.model.Faction;
import org.myproject.deckbuilder.model.CardType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardRepository extends MongoRepository<Card, Integer> {

  List<Card> findByFaction(Faction faction);

  List<Card> findByCardType(CardType cardType);
}
