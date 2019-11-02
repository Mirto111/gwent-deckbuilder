package org.myproject.deckbuilder.model;

import org.myproject.deckbuilder.model.Card;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode()
public class CardWithQuant {

    @DBRef
    private Card card;

    private int quantity;

}
