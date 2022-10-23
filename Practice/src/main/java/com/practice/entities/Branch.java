package com.practice.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branch_id;

	private String branch_name;
	
	@OneToMany
	List<Subject> subjects;
	
	@OneToMany
	List<Student1> students;

	public Branch(int branch_id, String branch_name, List<Subject> subjects,List<Student1> students) {
		super();
		this.branch_id = branch_id;
		this.branch_name = branch_name;
		this.subjects = subjects;
		this.students = students;
	}

	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<Student1> getStudents() {
		return students;
	}

	public void setStudents(List<Student1> students) {
		this.students = students;
	}
}
