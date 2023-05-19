package com.flashcards.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(EntityListeners.class)
public class Flashcard{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long flashcardId;
	
	@Column(unique = true)
	private String word;
	
	@Column 
	private String definition;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "listId", nullable = false)
	// @JsonIgnore is used to ignore the logical property used in serialization and deserialization.
	// Check for circular references: Circular references in your object graph can cause issues during serialization. 
	// Make sure that your objects do not have circular dependencies or consider using Jackson annotations 
	// like @JsonIgnore to exclude specific properties from serialization.
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