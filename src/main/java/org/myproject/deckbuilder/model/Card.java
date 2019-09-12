package org.myproject.deckbuilder.model;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Set;


//@Entity
//@Table(name = "cards")
@Data
@EqualsAndHashCode()//callSuper = true
@Document(value = "cards")
public class Card  {

  @Id
  private String _id;

  @Field(value = "name.en-US")
  private String name;

  private int provision;

  private int strength;


  private Faction faction;

  //@Enumerated(EnumType.STRING)

  private Rarity rarity;
  @Field(value = "type")
  private CardTier cardTier;

  private Set<String> keywords;

  //@Column(name = "card_type")
  //@Enumerated(EnumType.STRING)

  private CardType cardType;
  @Field(value = "info.en-US")
  private String description;

  //@ElementCollection(fetch = FetchType.EAGER)
  //@CollectionTable(name = "cards_categories", joinColumns = @JoinColumn(name = "card_id"))
  //@Column(name = "card_category")
  private List<String> categories;
 @Field(value = "ingameId")
 private String image;

}
