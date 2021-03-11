package com.cg.jhl2.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author implements Serializable{
	@javax.persistence.Id
	@Column(name="id")
	private Long Id;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="author")//fetch=FetchType.EAGER)
	private Set<Book> books;
	
	public Author() {
		
	}
	public Author(String name,Long id) {
		super();
		Id = id;
		this.name = name;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
