package com.flashcards.model;

import java.io.Serializable;
import java.util.List;

public class FlashcardListDto{
	private int listId;
	private String name;
	private List<Flashcard> flashcards;
	
	public List<Flashcard> getFlashcards() {
		return flashcards;
	}
	
	public void setFlashcards(List<Flashcard> flashcards) {
		this.flashcards = flashcards;
	}
	public int getListId() {
		return listId;
	}
	public void setListId(int listId) {
		this.listId = listId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
