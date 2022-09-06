package com.bookingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.model.Place;
import com.bookingservice.repository.bookingrepository;

@Service
public class bookingservice {
	
	@Autowired
	private bookingrepository bookingrepository;
	
	
//	method to add the place
	public Place addplace(Place place) {
		return bookingrepository.save(place);
	}
	
// method to update place
	public void updateplace(String contact,float price,int id) {
		bookingrepository.updateplace(contact,price,id);
	}
	
//method to reserve the place 
	
	public void reservePlace(int id,String status) {
		bookingrepository.updatestatus(id,status);
	}
// method to get the places based on rating (top-bottom)
	
	public List<Place> getsortedplacestb(){
		return bookingrepository.findplacesBasedonrating();
	}
	
//	method to get the places based on rating (low-top)
	public List<Place> getplacedbt(){
		return bookingrepository.getplacebt();
	}
	
//	method to delete the place
	
	public void deleteplace(int id) {
		Place p = bookingrepository.getById(id);
		bookingrepository.delete(p);
	}
	
//	method to get all the places 
	public List<Place> getallplaces(){
		return bookingrepository.findAll();
	}
	
	public void updateplacename(String name ,int pid) {
		bookingrepository.updateplacename(name, pid);
	}
	public void updateplaceprice(float price ,int pid) {
		bookingrepository.updateplaceprice(price, pid);
	}
	
	public void updateplacelocation(String name ,int pid) {
		bookingrepository.updateplacelocation(name, pid);
	}
	public void updateplacecontact(String name ,int pid) {
		bookingrepository.updateplacecontact(name, pid);
	}
	public void updateplacedesc(String name ,int pid) {
		bookingrepository.updateplacedesc(name, pid);
	}
	public void updateplacerate(int rate ,int pid) {
		bookingrepository.updateplacerating(rate, pid);
	}
	public void updateplacetype(String name ,int pid) {
		bookingrepository.updateplacetype(name, pid);
	}
	
//	search place by location
	public List<Place> searchplace(String place){
		return bookingrepository.searchplace(place);
	}
	
	public List<Place> searchplacebyfeature(String place){
		return bookingrepository.searchplacebyfeatures(place);
	}

}
