package com.masai.Dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.Model.Student;

public class StudentDaoImpl {
	
	
	public ArrayList<String> getAllStudentName(){
	
		ArrayList<String> l = new ArrayList<>();
		EntityManager em = FMUtils.getConnection();
	
//	SELECT NAME FROM STUDENT;  -> NORMAL SQL QUERY
//	Select st.name from student st -> JPQL
//	WRITE ENTITY CLASS NAME IN JPQL QUERY 
		
	Query q = em.createQuery("select st.stname from Student st");
	
	l = (ArrayList<String>)q.getResultList();
		

	return l;
		
	}
	
	public ArrayList<Student> getAllStudent(){
	ArrayList<Student> l = new ArrayList<>();
	EntityManager em = FMUtils.getConnection();
	
//	SELECT * FROM STUDENT; -> NORMAL SQL QUERY
//	SELECT ST FROM STUDENT ST -> JPQL
//	INSTEAD OF * WE HAVE TO USE THE ALIAS NAME OF ENTITY CLASS
	Query q = em.createQuery("select st from Student st");
	
	l = (ArrayList<Student>) q.getResultList();
	
	
		return l;
		
		
	}
	
	public int getMaxMarks() {
    
	int max = 0;
	EntityManager em = FMUtils.getConnection();
//	AGGREGATE FUNCTION -> (MULTI-ROW-FUNCTION)
//	SO ON THE JPQL QUERY WE HAVE TO MENTION THE ALIAS CLASS FIELD NAME IN AGGREGATE FUNCTION
//	SELECT MAX(MARKS) FROM STUDENT -> NORMAL SQL QUERY
	Query q = em.createQuery("select max(st.marks) from Student st");
	
	max = (int) q.getSingleResult();
	
	return max;	
	
	}
	
	public int getMinMarks() {
		
	int min = 0;
	EntityManager em = FMUtils.getConnection();
//	AGGREGATE FUNCTION -> (MULTI-ROW-FUNCTION)
//	SO ON THE JPQL QUERY WE HAVE TO MENTION THE ALIAS CLASS FIELD NAME IN AGGREGATE FUNCTION
//	SELECT MIN(MARKS) FROM STUDENT -> NORMAL SQL QUERY
	Query q = em.createQuery("select min(st.marks) from Student st");	

	min = (int)q.getSingleResult();
	
        return min;	
	}
	
	
	public int getCountStudent() {
	
	int h =0;
	Long c =0L;	
	EntityManager em = FMUtils.getConnection();
	Query q = em.createQuery("select count(st) from Student st");
	c = (Long)q.getSingleResult();
	
	h += c;
	
	return h;
	
	}
    
	public List<String> getAllStNameHaveRLetter(){
	List<String> l = null;
	EntityManager em = FMUtils.getConnection();
	Query q = em.createQuery("select st.stname from Student st where st.stname like '%r%'");
	
	l = q.getResultList();
	
	return l;
		
		
	}
	
	public List<Student> getAllstByNativeSQl(){
	
	List<Student> l =null;
	EntityManager em = FMUtils.getConnection();

/*	HERE IS THE SYNTAX LIKE HOW CAN 
	WE USE NATIVE QUERY (DATABASE SPECIFIC) 
	IN JPQL SO FISRT WE 
	HAVE TO WRITE ON FIRST PARAMETER \
	AND ON SECOND WE HAVE MENTION THE ENTITY CLASS
	FOR THAT TABLE THAT WE CREATED 
	*/
	Query q  = em.createNativeQuery("select * from Student", Student.class);
	
	l = q.getResultList();	
	
	return l;
		
	}
	
	public Student searchStudentById(int i) {
	Student st = null;
	EntityManager em = FMUtils.getConnection();
    Query q = em.createNamedQuery("find st by id");
    q.setParameter("num", i);
    
    st = (Student)q.getSingleResult();
		
		return st;
	}
	
	
	public static void main(String[] args) {
	
		StudentDaoImpl st = new StudentDaoImpl();
		
		ArrayList<String> ans = st.getAllStudentName();
		
		ans.forEach(e -> System.out.println(e));
	
		
		ArrayList<Student> ans2;
		ans2 = st.getAllStudent();
		
		ans2.forEach(e -> System.out.println(e));
	
		List<String> ans3 = st.getAllStNameHaveRLetter();
		
		ans3.forEach(e -> System.out.println(e));
		
		List<Student> ans4 = st.getAllstByNativeSQl();
		
		System.out.println("\n\n==========================NATIVE=====================\n");
		
		ans4.forEach(e -> System.out.println(e));
		
		
		System.out.println("MAX MARKS : "+st.getMaxMarks());
		System.out.println("MIN MARKS : "+st.getMinMarks());
	    System.out.println("TOTAL STUDENT : "+st.getCountStudent());
		
	    System.out.println("\n\n========================NAMED QUERY====================\n"+st.searchStudentById(3));
		
	}

}
