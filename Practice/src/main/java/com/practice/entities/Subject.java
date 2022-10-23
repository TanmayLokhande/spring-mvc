package com.practice.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sub_id;
	
	private String sub_name;
	
	@ManyToOne
	private Branch branch;
	
	@ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER,			
		    mappedBy="subjects")
	List<Teacher1> teacher = new ArrayList<>();

	public Subject(int sub_id, String sub_name, Branch branch, List<Teacher1> teacher) {
		super();
		this.sub_id = sub_id;
		this.sub_name = sub_name;
		this.branch = branch;
		this.teacher = teacher;
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSub_id() {
		return sub_id;
	}

	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}

	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<Teacher1> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<Teacher1> teacher) {
		this.teacher = teacher;
	}
	
	
	
	
}
