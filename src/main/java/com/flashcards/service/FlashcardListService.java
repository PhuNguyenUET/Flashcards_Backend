package com.flashcards.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashcards.model.FlashcardList;
import com.flashcards.repository.FlashcardListRepository;

@Service
public class FlashcardListService {
	@Autowired
	private FlashcardListRepository flashcardlistRepository;
	
	public List<FlashcardList> getAllLists() {
		List <FlashcardList> flashcardLists = new ArrayList<FlashcardList>();
		flashcardlistRepository.findAll().forEach(list -> flashcardLists.add(list));
		return flashcardLists;
	}
	
	public FlashcardList getListById (int id) {
		return flashcardlistRepository.findById(id).get();
	}
	
	public void saveOrUpdate (FlashcardList list) {
		flashcardlistRepository.save(list);
	}
	
	public void delete (int id) {
		flashcardlistRepository.deleteById(id);
	}
	
	public void update (FlashcardList list, int id) {
		flashcardlistRepository.save(list);
	}
}
