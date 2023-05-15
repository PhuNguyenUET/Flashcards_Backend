package com.flashcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.flashcards.model.FlashcardList;

public interface FlashcardListRepository extends JpaRepository <FlashcardList, Integer>{

}
