package org.myproject.deckbuilder.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.myproject.deckbuilder.model.Card;
import org.myproject.deckbuilder.model.CardWithQuant;
import org.myproject.deckbuilder.model.Deck;
import org.myproject.deckbuilder.model.User;
import org.myproject.deckbuilder.repository.DeckRepository;
import org.myproject.deckbuilder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class DeckControllerTest {

  @Autowired
  private DeckRepository deckRepository;
  @Autowired
  private UserRepository userRepository;

  @BeforeAll
  public static void init(@Autowired MongoTemplate mongoTemplate) throws IOException {

    TestData.initialize(mongoTemplate, "users", new File("src/test/resources/usersTest.json"),
        Document.class);
    TestData.initialize(mongoTemplate, "cards", new File("src/test/resources/cardsTest.json"),
        Document.class);
    TestData.initialize(mongoTemplate, "decks", new File("src/test/resources/decksTest.json"),
        Document.class);
  }

  @Order(1)
  @Test
  public void findAll() {

    List<Deck> decks = deckRepository.findAll();
    System.out.println(decks);
    assertEquals(2, decks.size());

  }

  @Order(4)
  @Test
  public void create() {

    Deck deck = new Deck();
    List<CardWithQuant>cards = new ArrayList<>();

    deck.setId("1423434344");
    deck.setLeader(TestData.leader);
    deck.setDescription("tttt");
    cards.add(new CardWithQuant(TestData.card1, 1));
    cards.add(new CardWithQuant(TestData.card2, 1));
    User user = userRepository.findById("23434343425").get();
    deck.setUser(user);

    deckRepository.save(deck);

    assertEquals(deck, deckRepository.findById("1423434344").get());
  }

  @Order(3)
  @Test
  public void delete() {
    Deck deck = deckRepository.findById("1423434342").get();
    assertNotNull(deck);
    deckRepository.deleteById("1423434342");
    Deck deck1 = deckRepository.findById("1423434342").orElse(null);
    assertNull(deck1);
  }

  @Order(2)
  @Test
  public void findAllByUser() {
    List<Deck> decks = deckRepository.findAllByUserId("23434343425");
    assertEquals(1, decks.size());
  }
}