package com.flashcards.model;

import java.util.List;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class FlashcardList implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int listId;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "list", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
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

	
	// Hibernate perform a persist on the parent first, then the children
	// minus foreign key second, then the child foreign key
	// with the parent's primary key
	// But the third step failed somehow (maybe due to
	// mismatch between JSON and @Entity structure
	// So I did it manually
	public void setFlashcards(List<Flashcard> flashcards) {
		this.flashcards = flashcards;
		for (Flashcard card: flashcards) {
			card.setList(this);
		}
	}
	
	public void addWord(Flashcard card) {
		flashcards.add(card);
		card.setList(this);
	}
	
	public void addWords(List <Flashcard> cards) {
		for (Flashcard card : cards) {
			addWord(card);
		}
	}
	
	public void deleteWord(Flashcard card) {
		flashcards.remove(card);
	}
	
	public void deleteById(int cardId) {
		flashcards.remove(cardId);
	}
}
