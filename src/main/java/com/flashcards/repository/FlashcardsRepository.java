package com.flashcards.repository;

import org.springframework.data.repository.CrudRepository;
import com.flashcards.model.Flashcards;

public interface FlashcardsRepository extends CrudRepository<Flashcards, Integer> {
}
