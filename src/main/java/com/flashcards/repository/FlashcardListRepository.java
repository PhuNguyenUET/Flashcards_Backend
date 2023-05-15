package com.flashcards.repository;

import org.springframework.data.repository.CrudRepository;
import com.flashcards.model.FlashcardList;

public interface FlashcardListRepository extends CrudRepository <FlashcardList, Integer>{

}
