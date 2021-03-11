package com.cg.jhl2.ui;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.cg.jhl2.entity.Book;
import com.cg.jhl2.util.JPAUtil;

public class App02 {

	public static void main(String[] args) {
		EntityManager em=JPAUtil.getEntityManager();
		String jpql="SELECT e FROM Book e";
		TypedQuery<Book> tqry=em.createQuery(jpql,Book.class);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter author name");
		String name=sc.next();
		tqry.setParameter("authorName",name);
		List<Book> books =tqry.getResultList();
		if(books.isEmpty()) {
			System.out.println("no employees found");
		}else {
			books.forEach(System.out::println);
		}
		JPAUtil.shutdown();
	}

}
