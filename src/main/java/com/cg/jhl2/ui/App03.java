package com.cg.jhl2.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.jhl2.entity.Book;
import com.cg.jhl2.util.JPAUtil;

public class App03 {

	public static void main(String[] args) {
		EntityManager em=JPAUtil.getEntityManager();
		String jpql="SELECT e FROM Book e WHERE e.price between :limit1 and :limit2";
		TypedQuery<Book> tqry=em.createQuery(jpql,Book.class);
		tqry.setParameter("limit1",500.0);
		tqry.setParameter("limit2",1000.00);
		List<Book> books =tqry.getResultList();
		if(books.isEmpty()) {
			System.out.println("no employees found");
		}else {
			books.forEach(System.out::println);
		}
		JPAUtil.shutdown();

	}

}
