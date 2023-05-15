package com.flashcards.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flashcards.service.FlashcardListService;
import com.flashcards.service.FlashcardsService;
import com.flashcards.model.*;

@RestController
public class FlashcardsController {
	@Autowired
	FlashcardListService flashcardListService;
	@Autowired
	FlashcardsService flashcardsService;
	
	@GetMapping("/flashcardlist")
	private List<FlashcardList> getAllLists() {
		return flashcardListService.getAllLists();
	}
	
	@GetMapping("/flashcardlist/{listId}")
	private FlashcardList getList(@PathVariable int listId) {
		return flashcardListService.getListById(listId);
	}
	
	@DeleteMapping("/flashcardlist/{listId}")
	private void deleteList(@PathVariable int listId) {
		flashcardListService.delete(listId);
	}
	
	@PostMapping("/flashcardlists")
	private int saveList (@RequestBody FlashcardList flashcardList) {
		flashcardListService.saveOrUpdate(flashcardList);
		return flashcardList.getListId();
	}
	
	@PutMapping("/flashcardlists")
	private FlashcardList update (@RequestBody FlashcardList flashcardList) {
		flashcardListService.saveOrUpdate(flashcardList);
		return flashcardList;
	}
}
