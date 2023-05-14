package com.flashcards.repository;

import org.springframework.data.repository.CrudRepository;
import com.flashcards.model.FlashcardsList;

public interface FlashcardsRepository extends CrudRepository<FlashcardsList, Integer> {
}
