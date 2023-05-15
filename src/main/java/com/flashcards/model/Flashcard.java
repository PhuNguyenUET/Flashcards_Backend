package com.flashcards.model;

import jakarta.persistence.*;
@Entity
@Table
public class Flashcard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int flashcardId;
	@Column
	private String word;
	@Column 
	private String definition;
	
	@ManyToOne
	@JoinColumn(name = "listId")
	private FlashcardList list;
	
	public int getFlashcardId() {
		return flashcardId;
	}
	public void setFlashcardId(int flashcardId) {
		this.flashcardId = flashcardId;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
}