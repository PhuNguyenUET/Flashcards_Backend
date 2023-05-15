package com.flashcards.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.flashcards.model.Flashcard;

public interface FlashcardsRepository extends CrudRepository<Flashcard, Integer> {
	List<Flashcard> findAllByListId(int listId);
}
