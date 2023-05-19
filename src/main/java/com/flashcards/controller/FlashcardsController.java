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
import org.springframework.web.bind.annotation.RequestParam;
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
	private ResponseEntity<FlashcardListDto> getList(@PathVariable Long listId) {
		FlashcardList list = flashcardListService.getListById(listId);
		FlashcardListDto listResponse = modelMapper.map(list, FlashcardListDto.class);
		return ResponseEntity.ok().body(listResponse);
	}
	
	@GetMapping("/flashcards/{listId}")
	private List<FlashcardDto> getFlashcards(@PathVariable Long listId) {
		FlashcardList list = flashcardListService.getListById(listId);
		List <Flashcard> flashcards = list.getFlashcards();
		return flashcards.stream().map(card -> modelMapper.map(card, FlashcardDto.class)).collect(Collectors.toList());
	}
	
	@GetMapping("/flashcards") 
	private List<FlashcardDto> getAllFlashcards() {
		return flashcardsService.getAllFlashcards().stream().map(card -> modelMapper.map(card, FlashcardDto.class)).collect(Collectors.toList());
	}
	
	@GetMapping("flashcardlist")
	private ResponseEntity<FlashcardListDto> getFlashcardListByName (@RequestParam(value = "name") String name) {
		FlashcardList list = flashcardListService.getListByName(name);
		FlashcardListDto listResponse = modelMapper.map(list, FlashcardListDto.class);
		return ResponseEntity.ok().body(listResponse);
	}
	
	@DeleteMapping("/flashcardlist/{listId}")
	private void deleteList(@PathVariable Long listId) {
		flashcardListService.delete(listId);
	}
	
	@DeleteMapping("/flashcard/{listId}/{word}")
	private void deleteCard(@PathVariable Long listId, @PathVariable String word) {
		FlashcardList list = flashcardListService.getListById(listId);
		flashcardsService.delete(list, word);
	}
	
	@PostMapping("/flashcardlists")
	private Long saveList (@RequestBody FlashcardListDto listDto) {
		FlashcardList listRequest = modelMapper.map(listDto, FlashcardList.class);
		flashcardListService.saveOrUpdate(listRequest);
		return listRequest.getListId();
	}
	
	@PostMapping("/flashcards/{listId}")
	private Long saveCard (@RequestBody FlashcardDto cardDto, @PathVariable Long listId) {
		Flashcard card = modelMapper.map(cardDto, Flashcard.class);
		FlashcardList list = flashcardListService.getListById(listId);
		card.setList(list);
		flashcardsService.saveOrUpdate(card);
		return card.getFlashcardId();
	}
	
	@PutMapping("/flashcardlists")
	private ResponseEntity<FlashcardListDto> updateList (@RequestBody FlashcardListDto listDto) {
		FlashcardList listRequest = modelMapper.map(listDto, FlashcardList.class);
		flashcardListService.saveOrUpdate(listRequest);
		return ResponseEntity.ok().body(listDto);
	}
	
	@PutMapping("/flashcards")
	private ResponseEntity<FlashcardDto> updateCard (@RequestBody FlashcardDto cardDto) {
		Flashcard card = modelMapper.map(cardDto, Flashcard.class);
		flashcardsService.saveOrUpdate(card);
		return ResponseEntity.ok().body(cardDto);
	}
}
