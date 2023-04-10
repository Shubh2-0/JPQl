package com.masai.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;



@Entity
//@Table(name = "student")


@NamedQuery(name = "find st by id", query = "select st from Student st where st.stId = :num")


public class Student {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stId;
	
	@Column(name = "name")
	private String stname;
	
	private String city;
	
	private int marks;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int stId, String stname, String city, int marks) {
		super();
		this.stId = stId;
		this.stname = stname;
		this.city = city;
		this.marks = marks;
	}

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student Id : " + stId + "\nName : " + stname + "\nCity : " + city + "\nMarks : " + marks + "\n\n==\n\n";
	}
	
	
	
}
