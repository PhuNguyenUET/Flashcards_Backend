package com.flashcards.model;

import java.io.Serializable;

public class FlashcardDto{
	private int flashcardId;
	private String word;
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
