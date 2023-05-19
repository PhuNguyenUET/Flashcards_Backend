package com.flashcards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.flashcards.model.Flashcard;
import com.flashcards.model.FlashcardList;

public interface FlashcardsRepository extends JpaRepository<Flashcard, Integer> {
	Flashcard findByWordAndList(String word, FlashcardList list);
}
