package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String phone;
	private String email;
	private String role;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "uid")
	private List<Question> questions;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "uid")
	private List<Answer> answers;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String password, String phone, String role,String email) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.role = role;
		this.email=email;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public void addQuestion(Question question) {
		if(this.questions==null) {
			this.questions= new ArrayList<Question>();
		}
		this.questions.add(question);
	}
	
	public void addAnswer(Answer answer) {
		if(this.answers==null) {
			this.answers= new ArrayList<Answer>();
		}
		this.answers.add(answer);
	}
	
	

}
