package org.myproject.deckbuilder.model;

import java.util.List;
import org.myproject.deckbuilder.model.Card;
import org.myproject.deckbuilder.model.CardWithQuant;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode()
@ToString
@Document(value = "decks")
public class Deck {

  @Id
  private String _id;

  private String name;

  @DBRef
  private Card leader;

  private String description;

  private int provision;

  private int maxProvision;

  private int minCards;

  private int cardsContained;

  private int minUnits;

  private int unitsContained;

  private int scraps;

  private List<CardWithQuant> deckList;

}
