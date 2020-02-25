package org.myproject.deckbuilder.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode()
@ToString
@Document(value = "users")
public class User {

  @Id
  private String id;

  @Indexed(unique = true)
  private String username;

  @NotBlank
  private String password;

  @NotNull
  private Role role;

}