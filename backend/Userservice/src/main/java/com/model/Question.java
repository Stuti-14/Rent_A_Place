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
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String question;
	private int userid;
	private String username;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "qid")
	private List<Answer> answers;
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(String question, int userid, String username, List<Answer> answers) {
		super();
		this.question = question;
		this.userid = userid;
		this.username = username;
		this.answers = answers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public void addanswer(Answer answer) {
		if(this.answers == null) {
			this.answers= new ArrayList<Answer>();
		}
		this.answers.add(answer);
	}

}
