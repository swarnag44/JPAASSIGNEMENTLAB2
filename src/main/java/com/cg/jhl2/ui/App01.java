package com.cg.jhl2.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.cg.jhl2.entity.Book;
import com.cg.jhl2.util.JPAUtil;

public class App01 {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		String jpql = "SELECT e FROM Book e";
		TypedQuery<Book> tqry = em.createQuery(jpql, Book.class);
		List<Book> books =tqry.getResultList();
		if (books.isEmpty()) {
			System.out.println("No employees found");
		} else {
			books.forEach(System.out::println);
		}
		JPAUtil.shutdown();
	}

}
