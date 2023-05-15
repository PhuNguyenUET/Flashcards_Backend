package com.flashcards.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashcards.model.Flashcard;
import com.flashcards.repository.FlashcardsRepository;

@Service
public class FlashcardsService {
	@Autowired
	private FlashcardsRepository flashcardsRepository;
	
	public List<Flashcard> getAllFlashcards() {
		List <Flashcard> flashcardsLists = new ArrayList<>();
		flashcardsRepository.findAll().forEach(flashcard -> flashcardsLists.add(flashcard));
		return flashcardsLists;
	}
	
	/* public List<Flashcard> getAllFlashcardsInList(int listId) {
		List <Flashcard> flashcardsLists = new ArrayList<>();
		flashcardsRepository.findAllByListId(listId).forEach(flashcard -> flashcardsLists.add(flashcard));
		return flashcardsLists;
	} */
	
	public Flashcard getFlashcardById (int id) {
		return flashcardsRepository.findById(id).get();
	}
	
	public void saveOrUpdate (Flashcard flashcard) {
		flashcardsRepository.save(flashcard);
	}
	
	public void delete (int id) {
		flashcardsRepository.deleteById(id);
	}
	
	public void update (Flashcard flashcard, int id) {
		flashcardsRepository.save(flashcard);
	}
}
