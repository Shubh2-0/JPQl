package com.masai.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FMUtils {
	
	
	static final EntityManagerFactory emf;
	
	static {
	
		emf = Persistence.createEntityManagerFactory("st");
		
	}
	
	public static EntityManager getConnection() {
	
		return emf.createEntityManager();
		
	}
	
	
//	public static void main(String[] args) {
//	
//		System.out.println(FMUtils.getConnection());
//		
//	}
	

}
