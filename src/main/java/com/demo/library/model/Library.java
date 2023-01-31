package com.demo.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Library {
	@Id
	@GeneratedValue
	Integer id;
	String author;
	String title;
	Double cost;
	
	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Library(Integer id, String author, String title, Double cost) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.cost = cost;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Library [id=" + id + ", author=" + author + ", title=" + title 
				+ ", cost=" + cost + "]";
	}
	
}
