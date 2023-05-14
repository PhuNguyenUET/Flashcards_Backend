package com.flashcards.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class FlashcardsList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int listId;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "list", cascade = CascadeType.ALL) 
	private List<Flashcard> flashcards;

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

	public List<Flashcard> getFlashcards() {
		return flashcards;
	}

	public void setFlashcards(List<Flashcard> flashcards) {
		this.flashcards = flashcards;
	}
}
