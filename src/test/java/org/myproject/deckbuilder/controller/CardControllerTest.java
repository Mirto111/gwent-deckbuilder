package org.myproject.deckbuilder.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.bson.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.myproject.deckbuilder.model.Card;
import org.myproject.deckbuilder.model.CardType;
import org.myproject.deckbuilder.model.Faction;
import org.myproject.deckbuilder.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@DataMongoTest
@ExtendWith(SpringExtension.class)
public class CardControllerTest {

  @Autowired
  private CardRepository cardRepository;

  @BeforeAll
  public static void init(@Autowired MongoTemplate mongoTemplate) throws IOException {
    TestData.initialize(mongoTemplate, "cards", new File("src/test/resources/cardsTest.json"),
        Document.class);
  }

  // 5 cards, 2 neutral, 3 diff factions(1 leader)

  @Test
  public void get() {

    assertEquals(TestData.card1, cardRepository.findById(112108).get());
  }

  @Test
  public void findAll() {
    List<Card> allCards = cardRepository.findAll();

    assertEquals(5, allCards.size());
  }

  @Test
  public void findByFaction() {
    List<Card> factCards = cardRepository.findByFaction(Faction.Neutral);

    assertEquals(Faction.Neutral, factCards.get(0).getFaction());
    assertEquals(2, factCards.size());
  }

  @Test
  public void findAllLeaders() {
    List<Card> leadCards = cardRepository.findByCardType(CardType.Leader);
    assertEquals(CardType.Leader, leadCards.get(0).getCardType());
    assertEquals(1, leadCards.size());
  }

}