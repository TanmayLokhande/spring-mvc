package com.practice.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.transaction.Transactional;


@Entity
public class Teacher1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;
	
	private String tName;
	
	@ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	
	@JoinTable(name="TEACHER_SUBJECT", 
				joinColumns={@JoinColumn(name="teacher_id")}, 
				inverseJoinColumns={@JoinColumn(name="subject_id")})
	List<Subject> subjects = new ArrayList<>();

	public Teacher1(int teacherId, String tName, List<Subject> subjects) {
		super();
		this.teacherId = teacherId;
		this.tName = tName;
		this.subjects = subjects;
	}

	public Teacher1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
	
	
}
