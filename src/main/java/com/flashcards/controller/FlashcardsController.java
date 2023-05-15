package com.flashcards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.flashcards.service.FlashcardsListService;
import com.flashcards.service.FlashcardsService;

public class FlashcardsController {
	@Autowired
	FlashcardsListService flashcardsListService;
	@Autowired
	FlashcardsService flashcardsService;
	
	@GetMapping("/flashcardlists")
	
}
