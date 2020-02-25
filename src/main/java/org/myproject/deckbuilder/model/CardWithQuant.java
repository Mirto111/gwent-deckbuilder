package org.myproject.deckbuilder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@EqualsAndHashCode()
@AllArgsConstructor
@NoArgsConstructor
public class CardWithQuant {

  @DBRef
  private Card card;

  private int quantity;

}
