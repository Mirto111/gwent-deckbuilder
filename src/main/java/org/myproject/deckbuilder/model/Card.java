package org.myproject.deckbuilder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@EqualsAndHashCode()
@Document(value = "cards")
public class Card {

  @Id
  @Field(value = "ingameId")
  @JsonProperty(value = "ingameId") // for tests
  private String id;

  private Map<String, String> name;

  private int provision;

  private int strength;

  private Faction faction;

  private Rarity rarity;

  @Field(value = "type")
  @JsonProperty(value = "type") // for tests
  private CardTier cardTier;

  private Set<String> keywords;

  private CardType cardType;

  @Field(value = "info")
  @JsonProperty(value = "info") // for tests
  private Map<String, String> description;

  private List<String> categories;

}
