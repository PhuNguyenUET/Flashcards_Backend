package com.flashcards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.flashcards.model.Flashcard;

public interface FlashcardsRepository extends CrudRepository<Flashcard, Integer> {
}
