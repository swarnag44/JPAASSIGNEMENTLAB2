package com.cg.jhl2.ui;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.jhl2.entity.Author;
import com.cg.jhl2.entity.Book;
import com.cg.jhl2.util.JPAUtil;


public class App4 {

	public static void main(String[] args) {
		EntityManager em=JPAUtil.getEntityManager();
		Author c1=new Author("Swarna",1L);
		Author c2=new Author("rekha",2L);
		
		Book s1=new Book("ramayan",675.9,1L);
		Book s2=new Book("Mermaid",8976.5,2L);
		Book s3=new Book("mahabharath",987.5,3L);
		Book s4=new Book("dev",9876.5,4L);
		Set<Book> authorswa=new LinkedHashSet<>();
		authorswa.add(s2);
		authorswa.add(s4);
		Set<Book> authorrek=new LinkedHashSet<>();
		authorrek.add(s1);
		authorrek.add(s3);
		
		c1.setBooks(authorswa);
		c2.setBooks(authorrek);
		
		s1.setAuthor(c1);
		s2.setAuthor(c2);
		s3.setAuthor(c1);
		s4.setAuthor(c2);
		EntityTransaction txn=em.getTransaction();
		txn.begin();
		em.persist(c1);
		em.persist(c2);
		txn.commit();
		JPAUtil.shutdown();
	}

}
