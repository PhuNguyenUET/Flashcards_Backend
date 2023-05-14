package com.flashcards.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Flashcards {
	@Id
	@Column
	private int flashcardId;
	@Column
	private String word;
	@Column 
	private String definition;
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