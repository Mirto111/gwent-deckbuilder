package org.myproject.deckbuilder.model;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode()
@ToString
@Document(value = "decks")
public class Deck {

  @Id
  private String id;

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

  @DBRef(lazy = true)
  private User user;

}
