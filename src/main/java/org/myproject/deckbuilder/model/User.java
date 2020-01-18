package org.myproject.deckbuilder.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode()
@Document(value = "users")
public class User {

    @Id
    private String _id;
 
    
    @Indexed(unique=true)
    private String username;
    
    @NotBlank
    private String password;

    @NotNull
    private Role role;

}