package com.flashcards.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	private ModelMapper modelMapper;
	@Autowired
	FlashcardListService flashcardListService;
	@Autowired
	FlashcardsService flashcardsService;
	
	@GetMapping("/flashcardlists")
	private List<FlashcardListDto> getAllLists() {
		return flashcardListService.getAllLists().stream().map(list -> modelMapper.map(list, FlashcardListDto.class)).collect(Collectors.toList());
	}
	
	@GetMapping("/flashcardlist/{listId}")
	private ResponseEntity<FlashcardListDto> getList(@PathVariable int listId) {
		FlashcardList list = flashcardListService.getListById(listId);
		FlashcardListDto listResponse = modelMapper.map(list, FlashcardListDto.class);
		return ResponseEntity.ok().body(listResponse);
	}
	
	@GetMapping("/flashcard/{listId}")
	private List<FlashcardDto> getFlashcards(@PathVariable int listId) {
		FlashcardList list = flashcardListService.getListById(listId);
		List <Flashcard> flashcards = list.getFlashcards();
		return flashcards.stream().map(card -> modelMapper.map(card, FlashcardDto.class)).collect(Collectors.toList());
	}
	
	@GetMapping("flashcards") 
	private List<FlashcardDto> getAllFlashcards() {
		return flashcardsService.getAllFlashcards().stream().map(card -> modelMapper.map(card, FlashcardDto.class)).collect(Collectors.toList());
	}
	
	@GetMapping("flashcard/{name}")
	private ResponseEntity<FlashcardListDto> getFlashcardByName (@PathVariable String name) {
		FlashcardList list = flashcardListService.getListByName(name);
		FlashcardListDto listResponse = modelMapper.map(list, FlashcardListDto.class);
		return ResponseEntity.ok().body(listResponse);
	}
	
	@DeleteMapping("/flashcardlist/{listId}")
	private void deleteList(@PathVariable int listId) {
		flashcardListService.delete(listId);
	}
	
	@DeleteMapping("/flashcard/{listId}/{cardId}")
	private void deleteCard(@PathVariable int listId, @PathVariable int cardId) {
		FlashcardList list = flashcardListService.getListById(listId);
		list.deleteById(cardId);
	}
	
	@PostMapping("/flashcardlists")
	private int saveList (@RequestBody FlashcardListDto listDto) {
		FlashcardList listRequest = modelMapper.map(listDto, FlashcardList.class);
		flashcardListService.saveOrUpdate(listRequest);
		return listRequest.getListId();
	}
	
	@PostMapping("/flashcards/{listId}")
	private int saveCard (@RequestBody FlashcardDto cardDto, @PathVariable int listId) {
		Flashcard card = modelMapper.map(cardDto, Flashcard.class);
		FlashcardList list = flashcardListService.getListById(listId);
		list.addWord(card);
		return card.getFlashcardId();
	}
	
	@PutMapping("/flashcardlists")
	private ResponseEntity<FlashcardListDto> updateList (@RequestBody FlashcardListDto listDto) {
		FlashcardList listRequest = modelMapper.map(listDto, FlashcardList.class);
		flashcardListService.saveOrUpdate(listRequest);
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping("/flashcards")
	private ResponseEntity<FlashcardDto> updateCard (@RequestBody FlashcardDto cardDto) {
		Flashcard card = modelMapper.map(cardDto, Flashcard.class);
		flashcardsService.saveOrUpdate(card);
		return ResponseEntity.ok().body(cardDto);
	}
}
