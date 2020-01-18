package org.myproject.deckbuilder.repository;

import org.myproject.deckbuilder.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User getByUsername(String username);

}