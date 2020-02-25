package org.myproject.deckbuilder.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.myproject.deckbuilder.model.Card;
import org.myproject.deckbuilder.model.CardTier;
import org.myproject.deckbuilder.model.CardType;
import org.myproject.deckbuilder.model.Faction;
import org.myproject.deckbuilder.model.Rarity;
import org.springframework.data.mongodb.core.MongoTemplate;

public class TestData {

  public static Card leader = new Card();
  public static Card card1 = new Card();
  public static Card card2 = new Card();

  static {
    leader.setId("122105");
    leader.setName(Map.of("en-US", "Sigismund Dijkstra", "ru-RU", "Сигизмунд Дийкстра"));
    leader.setProvision(15);
    leader.setStrength(0);
    leader.setFaction(Faction.Syndicate);
    leader.setRarity(Rarity.Legendary);
    leader.setCardTier(CardTier.Leader);
    leader.setKeywords(Set.of("Order", "Coin", "Charge"));
    leader.setCardType(CardType.Leader);
    leader.setDescription(
        Map.of("en-US",
            "Order: Gain 1 Coin. Charge: 5\nWhenever you play a Crime card, gain 1 Coin.\n"
            , "ru-RU",
            "Приказ: получите 1 монету. Заряды: 5.\nПолучайте по 1 монете каждый раз, когда играете карту преступления.\n"
        ));
    leader.setCategories(Arrays.asList("Leader"));

    card1.setId("112108");
    card1.setName(Map.of("en-US", "Yennefer of Vengerberg", "ru-RU", "Йеннифэр из Венгерберга"));
    card1.setProvision(11);
    card1.setStrength(2);
    card1.setFaction(Faction.Neutral);
    card1.setRarity(Rarity.Legendary);
    card1.setCardTier(CardTier.Gold);
    card1.setKeywords(Set.of("Deploy",
        "Melee",
        "Ranged"));
    card1.setCardType(CardType.Unit);
    card1.setDescription(Map.of("en-US",
        "Deploy (Melee): Damage all other units by 2. \nDeploy (Ranged): Boost all other units by 2.\n",
        "ru-RU",
        "Размещение (рукопашный ряд): нанесите по 2 ед. урона всем остальным отрядам. \nРазмещение (дальнобойный ряд): усильте все остальные отряды на 2 ед.\n"
    ));
    card1.setCategories(Arrays.asList("Human",
        "Mage"));

    card2.setId("112101");
    card2.setCardTier(CardTier.Gold);
    card2.setCardType(CardType.Unit);
    card2.setCategories(Arrays.asList("Witcher"));
    card2.setDescription(Map.of("en-US",
        "Whenever you lose a round, return this unit from the battlefield to your hand.", "ru-RU",
        "Возвращайте этот отряд с поля в вашу руку каждый раз, когда проигрываете раунд."));
    card2.setFaction(Faction.Neutral);
    card2.setKeywords(Collections.emptySet());
    card2.setName(Map.of("en-US",
        "Ciri", "ru-RU",
        "Цири"));
    card2.setProvision(8);
    card2.setRarity(Rarity.Legendary);
    card2.setStrength(4);

  }

  public static <T> void initialize(MongoTemplate template, String collectionName, File file,
      Class<T> clazz) throws IOException {

    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(
        DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    JsonParser parser = new JsonFactory()
        .createParser(new FileReader(file));
    Iterator<T> it = mapper.readValues(parser, clazz);

    while (it.hasNext()) {
      template.save(it.next(), collectionName);
    }
  }
}


