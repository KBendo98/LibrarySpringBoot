package com.demo.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LIBRARY_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class Library {
	@Id
	@GeneratedValue
	Integer bookId;
	String author;
	String title;
	Double cost;
}
