package com.bookingservice.controller;

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

import com.bookingservice.model.Place;
import com.bookingservice.service.bookingservice;

@RestController
@CrossOrigin
public class bookingcontroller {
	
	@Autowired
	private bookingservice bookingservice;

	@PostMapping(value = "addplace")
	public Place addplace(@RequestBody Place place) {
		return bookingservice.addplace(place);
	}

	@PutMapping(value = "updateplace/{contact}/{price}/{id}")
	public void updateplace(@PathVariable("contact") String Contact, @PathVariable("price") float price,
			@PathVariable("id") int id) {
		bookingservice.updateplace(Contact, price, id);
	}

	@PutMapping(value="updatestatus/{id}/{status}")
	public void updatestatus(@PathVariable("id") int id, @PathVariable("status") String status) {
		bookingservice.reservePlace(id, status);
	}
	@DeleteMapping(value = "deleteplace/{id}")
	public void deleteplace(@PathVariable("id") int id) {
		bookingservice.deleteplace(id);
	}
	

	@GetMapping("findallplaces")
	public List<Place> getplaces(){
		return bookingservice.getallplaces();
	}
	@PutMapping("updatepname/{name}/{pid}")
	public void updateplacename(@PathVariable("name") String name ,@PathVariable("pid") int pid) {
		bookingservice.updateplacename(name, pid);
	}
	
	@PutMapping("updatepprice/{price}/{pid}")
	public void updateplaceprice(@PathVariable("price") float price ,@PathVariable("pid") int pid) {
		bookingservice.updateplaceprice(price, pid);
	}
	
	@PutMapping("updateploc/{name}/{pid}")
	public void updateplaceloc(@PathVariable("name") String name ,@PathVariable("pid") int pid) {
		bookingservice.updateplacelocation(name, pid);
	}
	@PutMapping("updatepdesc/{name}/{pid}")
	public void updateplacedesc(@PathVariable("name") String name ,@PathVariable("pid") int pid) {
		bookingservice.updateplacedesc(name, pid);
	}
	@PutMapping("updateprate/{rate}/{pid}")
	public void updateplacename(@PathVariable("rate") int name ,@PathVariable("pid") int pid) {
		bookingservice.updateplacerate(name, pid);
	}
	@PutMapping("updateptype/{type}/{pid}")
	public void updateplacetype(@PathVariable("type") String name ,@PathVariable("pid") int pid) {
		bookingservice.updateplacetype(name, pid);
	}
	@PutMapping("updatepcontact/{contact}/{pid}")
	public void updateplacecontact(@PathVariable("contact") String name ,@PathVariable("pid") int pid) {
		bookingservice.updateplacecontact(name, pid);
	}
	@GetMapping("searchplaces/{place}")
	public List<Place> searchplaces(@PathVariable("place") String place){
		return bookingservice.searchplace(place);
	}
	@GetMapping("searchplacesbyfeature"
			+ "/{place}")
	public List<Place> searchplacesbyFeatures(@PathVariable("place") String place){
		return bookingservice.searchplacebyfeature(place);
	}

	
	@GetMapping(value = "top2bottom")
	public List<Place> searchplacestopbottom(){
		return bookingservice.getsortedplacestb();
	}
	@GetMapping(value = "bottom2top")
	public List<Place> searchplacesbottomtop(){
		return bookingservice.getplacedbt();
	}
	
}
