package org.myproject.deckbuilder;

import org.myproject.deckbuilder.repository.CardRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = CardRepository.class)
public class DeckBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeckBuilderApplication.class, args);
	}

}

