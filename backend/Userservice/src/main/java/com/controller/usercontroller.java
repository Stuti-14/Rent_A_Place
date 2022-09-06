package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Answer;
import com.model.Question;
import com.model.User;
import com.model.request;
import com.repo.userRepo;
import com.service.Userservice;

@RestController
@CrossOrigin
public class usercontroller {
	@Autowired
	private Userservice userservice;
	@PostMapping(value = "register")
	public User registerUser(@RequestBody User user) throws Exception {
		return userservice.registerUser(user);
	}
	@PostMapping(value = "login")
	public User login(@RequestBody request user) throws Exception {
		return userservice.loginUser(user);
	}
	@PostMapping(value = "addQuestion")
	public void addingQuestion(@RequestBody Question question) throws Exception {
		userservice.addQuestion(question);
	}
	
	@PostMapping(value = "addAnswer")
	public void addAnswer(@RequestBody Answer answer) throws Exception {
		userservice.addAnswer(answer);
	}
//	get all Question of Specific User
	@GetMapping(value = "getUserQuestions/{id}")
	public List<Question> getUserQuestions(@PathVariable("id") int id){
		return userservice.getUserQuestions(id);
	}
	@GetMapping(value = "findallCustomers")
	public List<User> getCustomers(){
		return userservice.getallUsers();
	}
	
//	to get all the Questions 
	@GetMapping(value = "getallQuestions")
	public List<Question> getAllQuestions(){
		return userservice.getallQuestions();
	}
	
//	toupdate User
	@PutMapping(value = "updateUser/{id}/{phn}")
	public void updateUser(@PathVariable("id") int uid,@PathVariable("phn") String phone) {
		userservice.updateUser(uid, phone);
	}
	
//	to ddelete user
	@DeleteMapping(value = "deletecustomer/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		userservice.deleteCustomer(id);
	}

}
