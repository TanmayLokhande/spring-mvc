package com.practice.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_Id;
	
	private String student_name;
	
	@ManyToOne
	private Branch branch;

	public Student1(int student_Id, String student_name, Branch branch) {
		super();
		this.student_Id = student_Id;
		this.student_name = student_name;
		this.branch = branch;
	}

	public Student1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudent_Id() {
		return student_Id;
	}

	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

}
