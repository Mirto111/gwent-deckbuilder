package org.myproject.deckbuilder.model;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
//@MappedSuperclass
public abstract class BaseEntity {

  @Id
  protected String id;

  public boolean isNew() {
    return id == null;
  }

}
