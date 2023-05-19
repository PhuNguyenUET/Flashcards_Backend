package com.flashcards.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class FlashcardListDto{
	private Long listId;
	private String name;
	private List<Flashcard> flashcards;
	
	public List<Flashcard> getFlashcards() {
		return flashcards;
	}
	
	public void setFlashcards(List<Flashcard> flashcards) {
		this.flashcards = flashcards;
	}
	public Long getListId() {
		return listId;
	}
	public void setListId(Long listId) {
		this.listId = listId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
