package org.myproject.deckbuilder.model;

import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@EqualsAndHashCode()
@Document(value = "cards")
public class Card {

  @Id
  private int id;

  private Map<String, String> name;

  private int provision;

  private int strength;

  private Faction faction;

  private Rarity rarity;

  @Field(value = "type")
  private CardTier cardTier;

  private Set<String> keywords;

  private CardType cardType;

  @Field(value = "info")
  private Map<String, String> description;

  private List<String> categories;

}
