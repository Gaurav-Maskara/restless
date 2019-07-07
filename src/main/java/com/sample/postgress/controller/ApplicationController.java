package com.sample.postgress.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.consumer.beans.Joke;
import com.consumer.beans.Quote;
import com.sample.postgress.entity.Contact;
import com.sample.postgress.entity.Employee;
import com.sample.postgress.entity.User;
import com.sample.postgress.service.ContactService;
import com.sample.postgress.service.EmployeeService;
import com.sample.postgress.service.UserService;

@RestController
@RequestMapping("/postgressApp")
public class ApplicationController {

	@Resource
	EmployeeService employeeService;

	@Resource
	UserService userService;
	
	@Resource
	ContactService contactService;


	@GetMapping(value = "/aboutSpring", produces = { "application/json" })
	Quote getAboutSpring() {

		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		return quote;
	}

	@GetMapping(value = "/tellJoke", produces = { "application/json" })
	String getJoke() {
		    RestTemplate restTemplate = new RestTemplate();
	        String  quote = restTemplate.getForObject("https://api.adviceslip.com/advice", String.class);
	        return quote;
	 }
	

	@GetMapping(value = "/userList")
	public List<User> getUsers() {
		return userService.findAll();

	}

	@PostMapping(value = "/createUser")
	public void createUser(@RequestBody User user) {
		userService.insertUser(user);

	}

	@PutMapping(value = "/updateUser")
	public void updateEmployee(@RequestBody User user) {
		userService.updateUser(user);

	}

	@DeleteMapping(value = "/deleteUserByUsername")
	public void deleteUser(@RequestBody User user) {
		userService.deleteUser(user);

	}
	
	@GetMapping(value = "/contacts")
	public List<Contact> getContacts() {
		return contactService.findAll();

	}
	
	@PostMapping(value = "/addContact")
	public String addContact(Contact contact) {
	   System.out.println("hello");	
		contactService.insertContact(contact);
		//return ResponseEntity.ok(new String("success"));
		//ResponseEntity<?>
		return "success";
	}
	
	

	@GetMapping(value = "/employeeList")
	public List<Employee> getEmployees() {
		return employeeService.findAll();

	}

	@PostMapping(value = "/createEmp")
	public void createEmployee(@RequestBody Employee emp) {
		employeeService.insertEmployee(emp);

	}

	@PutMapping(value = "/updateEmp")
	public void updateEmployee(@RequestBody Employee emp) {
		employeeService.updateEmployee(emp);

	}

	@PutMapping(value = "/executeUpdateEmp")
	public void executeUpdateEmployee(@RequestBody Employee emp) {
		employeeService.executeUpdateEmployee(emp);

	}

	@DeleteMapping(value = "/deleteEmpById")
	public void deleteEmployee(@RequestBody Employee emp) {
		employeeService.deleteEmployee(emp);

	}

}
