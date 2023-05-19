package com.flashcards.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class FlashcardDto{
	private Long flashcardId;
	private String word;
	private String definition;
	@JsonIgnore
	private FlashcardList list;
	public FlashcardList getList() {
		return list;
	}
	public void setList(FlashcardList list) {
		this.list = list;
	}
	public Long getFlashcardId() {
		return flashcardId;
	}
	public void setFlashcardId(Long flashcardId) {
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
