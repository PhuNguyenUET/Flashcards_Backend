package com.flashcards.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Flashcard implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int flashcardId;
	
	@Column
	private String word;
	
	@Column 
	private String definition;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "listId")
	private FlashcardList list;
	
	public FlashcardList getList() {
		return list;
	}
	public void setList(FlashcardList list) {
		this.list = list;
	}
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