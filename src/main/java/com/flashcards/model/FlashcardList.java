package com.flashcards.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(EntityListeners.class)
public class FlashcardList{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long listId;
	
	@Column(unique = true)
	private String name;
	
	@OneToMany(mappedBy = "list", cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
	private List<Flashcard> flashcards;

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
		for (Flashcard card: flashcards) {
			card.setList(this);
		}
		this.flashcards = flashcards;
	}
	
	public void addWord(Flashcard card) {
		flashcards.add(card);
		card.setList(this);
	}
	
	public void deleteWord(Flashcard card) {
		flashcards.remove(card);
	}
}
