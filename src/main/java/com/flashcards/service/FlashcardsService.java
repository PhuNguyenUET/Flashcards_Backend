package com.flashcards.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashcards.model.Flashcard;
import com.flashcards.model.FlashcardList;
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
	
	public Flashcard getFlashcardById (Long id) {
		return flashcardsRepository.findById(id).get();
	}
	
	public void saveOrUpdate (Flashcard flashcard) {
		flashcardsRepository.save(flashcard);
	}
	
	public void delete (Long id) {
		flashcardsRepository.deleteById(id);
	}
	
	public void delete (Flashcard flashcard) {
		flashcardsRepository.delete(flashcard);
	}
	
	public void delete (FlashcardList list, String word) {
		Flashcard card = flashcardsRepository.findByWordAndList(word, list);
		flashcardsRepository.delete(card);
	}
	
	public void update (Flashcard flashcard, int id) {
		flashcardsRepository.save(flashcard);
	}
}
