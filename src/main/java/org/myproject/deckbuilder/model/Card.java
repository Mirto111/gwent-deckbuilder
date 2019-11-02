package org.myproject.deckbuilder.model;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Set;

@Data
@EqualsAndHashCode()
@Document(value = "cards")
public class Card  {

  @Id
  private String _id;

  @Field(value = "name.en-US")
  private String name;

  private int provision;

  private int strength;

  private Faction faction;

  private Rarity rarity;

  @Field(value = "type")
  private CardTier cardTier;

  private Set<String> keywords;

  private CardType cardType;
 
  @Field(value = "info.en-US")
  private String description;

  private List<String> categories;

 @Field(value = "ingameId")
 private String image;

}
