package org.myproject.deckbuilder.repository;

import java.util.List;
import org.bson.types.ObjectId;
import org.myproject.deckbuilder.model.Card;
import org.myproject.deckbuilder.model.Faction;
import org.myproject.deckbuilder.model.CardType;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CardCrudRepository extends MongoRepository<Card,String> {

  Card findBy_id(String _id);


  List<Card> findByFaction(Faction faction);

  List<Card> findByCardType(CardType cardType);
}
