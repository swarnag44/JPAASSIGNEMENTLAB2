package com.cg.jhl2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book implements Serializable{
	@Id
	@Column(name="Id")
	private Long bookId;
	private String title;
	private Double price;
	
	@ManyToOne
	//@JoinColumn(name="b_id")
	private Author author;
	public Book() {
		
	}

	public Book( String title, Double price,Long bookId) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	 

	@Override
	public String toString() {
		return String.format("Book [ISBN=%s, title=%s, price=%s]", bookId, title, price);
	}
	
}
