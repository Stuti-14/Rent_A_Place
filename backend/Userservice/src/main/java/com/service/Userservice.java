package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Answer;
import com.model.Question;
import com.model.User;
import com.model.request;
import com.repo.userRepo;

@Service
public class Userservice {
	@Autowired
	public userRepo repo;

//	register the User
	public User registerUser(User user) throws Exception {
		User u1 = repo.findByEmail(user.getEmail());
		User u2 = repo.findByUsername(user.getUsername());
		if (u1 != null && u2 != null) {
			throw new Exception("User already Exist with " + user.getEmail());
		} else {
			return repo.save(user);
		}
	}

//	login to application
	public User loginUser(request request) throws Exception {
		User u = repo.authenticateuser(request.getUsername(), request.getPassword());
		if (u != null) {
			return u;
		} else {
			throw new Exception("incoorect password and email");
		}
	}

//	to get all the Users
	public List<User> getallUsers() {
		return repo.findAll();
	}

//	Adding Question
	public void addQuestion(Question question) throws Exception {
		User customer = repo.getById(question.getUserid());
		if (customer != null) {
			customer.addQuestion(question);
			repo.save(question);
		} else {
			throw new Exception("Customer is null");
		}
	}

//adding Answer
	public void addAnswer(Answer answer) throws Exception {
		User customer = repo.getById(answer.getCid());
		if (customer != null) {
			Question q = repo.findbyid(answer.getQid());
			if (q != null) {
				customer.addAnswer(answer);
				q.addanswer(answer);
				repo.save(answer);
			} else {
				throw new Exception(" Question is null");
			}

		} else {
			throw new Exception("Customer is null");
		}
	}

//to get all Question on console

	public List<Question> getallQuestions() {
		return repo.getAllQuestion();
	}
	
//	to get User questions
	public List<Question> getUserQuestions(int id){
		return repo.findUserQuestions(id);
	}
	
	//to update user
	public void updateUser(int uid,String phone) {
		repo.updateUser(uid, phone);
	}
	//to delete customer
	public void deleteCustomer(int id) {
		repo.deleteUser(id);
	}

}
