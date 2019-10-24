package com.sample.postgress.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.consumer.beans.Quote;
import com.sample.postgress.entity.Contact;
import com.sample.postgress.entity.Employee;
import com.sample.postgress.entity.User;
import com.sample.postgress.entity.VisitorDetails;
import com.sample.postgress.service.ContactService;
import com.sample.postgress.service.EmployeeService;
import com.sample.postgress.service.UserService;
import com.sample.postgress.service.VisitorDetailsService;

@RestController
@RequestMapping("/restless")
public class ApplicationController implements Serializable {
	
	private static final long serialVersionUID = 14778478478L;

	@Resource
	EmployeeService employeeService;

	@Resource
	UserService userService;

	@Resource
	ContactService contactService;

	@Resource
	VisitorDetailsService visitorDetailsService;
	

	@GetMapping(value = "/aboutSpring", produces = { "application/json" })
	Quote getAboutSpring() {

		RestTemplate restTemplate = new RestTemplate();
		
		Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		return quote;
	}

	@GetMapping(value = "/tellJoke", produces = { "application/json" })
	String getJoke() {
		RestTemplate restTemplate = new RestTemplate();
		String advice = restTemplate.getForObject("https://api.adviceslip.com/advice", String.class);
		return advice;
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
		return "success";
	}

	@PostMapping(value = "/addVisitorDetails")
	public void addIPAddressOfUser(VisitorDetails visitorDetails) {
		System.out.println("adding visitor details into the database");

		if ("106.202.71.154".equals(visitorDetails.getIp()) || "42.111.31.236".equals(visitorDetails.getIp())
				|| "42.111.26.24".equals(visitorDetails.getIp())) {
			return;
		}

		visitorDetailsService.insertVisitorDetails(visitorDetails);
		System.out.println("added successfully");
	}

	@GetMapping(value = "/visitorList")
	public List<VisitorDetails> getVisitors() {
		return visitorDetailsService.findAll();

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
	
	
	@GetMapping(value = "/java", produces = { "application/json" })
	public ArrayList<String> javaLessons() {
		
		ArrayList<String> urls=new ArrayList<String>();
		
		// General
		
		urls.add("Topics Recall: "+"https://www.journaldev.com/7153/core-java-tutorial");
		
		urls.add("Java: "+"https://www.tutorialspoint.com/java");
		urls.add("300 Java Interview Questions: "+"https://www.javatpoint.com/corejava-interview-questions");
		urls.add("Servelts Overview: "+"https://www.tutorialspoint.com/servlets/");
		urls.add("JSP: "+"https://www.tutorialspoint.com/jsp/");
		urls.add("Doubly checked singleton class: "+"https://www.journaldev.com/171/thread-safety-in-java-singleton-classes-with-example-code");
		urls.add("Static blocks in java: "+"https://www.geeksforgeeks.org/g-fact-79/");
        urls.add("Good Article on servlets must read: "+"https://stackoverflow.com/questions/3106452/how-do-servlets-work-instantiation-sessions-shared-variables-and-multithreadi/3106909#3106909"+"  "+"https://stackoverflow.com/questions/9555842/why-servlets-are-not-thread-safe/");
		
		
		// Hibernate
		urls.add("Hibernate: "+"https://www.tutorialspoint.com/hibernate");
		
		
       
	
		// SQL + Front end
        urls.add("SQL: "+"https://www.w3schools.com/sql/");
        urls.add("HTML: "+"https://www.w3schools.com/html/html_examples.asp");
        
		
        
        
        
        
        
        
        
        
        // Java 8
        urls.add("Lambda Expressions: "+"https://www.geeksforgeeks.org/lambda-expressions-java-8/");
        urls.add("Ierating usong Lambda: "+"https://beginnersbook.com/2017/01/lambda-expression-iterating-map-and-list-in-java-8/");
        
        
        
        
        // Spring
        urls.add("Spring Overview: "+"https://www.tutorialspoint.com/spring");
        urls.add("Spring Interview Questions: "+"https://www.springboottutorial.com/spring-interview-questions");
        urls.add("Difference between @Pathvariable, @RequestParam: "+"https://www.codebyamir.com/blog/spring-mvc-essentials-requestmapping-pathvariable-annotations");
       
        
        // Threads in java
        urls.add("Java Multithreading: "+"https://www.tutorialspoint.com/java/java_multithreading");
        urls.add("Oject Level vs Class Level Locking: "+"https://java2blog.com/object-level-locking-vs-class-level-locking-java/");
        urls.add("Concurrency: "+"https://www.tutorialspoint.com/java_concurrency/");
    	urls.add("Inter Thread Communication in Java: "+"https://www.javatpoint.com/inter-thread-communication-example");
        
        
    	// Good topics
    	urls.add("Fail fast and Fail Safe: "+"https://www.geeksforgeeks.org/fail-fast-fail-safe-iterators-java/");
    	urls.add("Difference between Enumeration and Iterator: "+"https://techdifferences.com/difference-between-iterator-and-enumeration-interface-in-java.html");
    	urls.add("Internal working of hash map: "+"https://www.geeksforgeeks.org/internal-working-of-hashmap-java/");
        urls.add("Garbage Collection in Java: "+"https://www.geeksforgeeks.org/garbage-collection-java/");
    	urls.add("Concurrent Hash Map: "+"https://www.geeksforgeeks.org/concurrenthashmap-in-java/");
    	urls.add("Can a method in sub class overloading a method in super class?: "+"https://stackoverflow.com/questions/24884151/can-a-method-in-sub-class-overloading-a-method-in-super-class");
    	urls.add("Shallow and Deep Cloning: "+"https://dzone.com/articles/shallow-and-deep-java-cloning");
    	urls.add("Hibernate Entity: "+"https://stackoverflow.com/questions/23214454/org-hibernate-mappingexception-unknown-entity-annotations-users");
    	urls.add("SQL Queries: "+"https://www.google.com/search?client=firefox-b-d&sxsrf=ACYBGNSzbVF-7rOotFya60Q-t93UTSRvKw%3A1569355551878&ei=H3eKXcalNZzD3LUPh5KWuAk&q=sql+query+interview+questions&oq=sql+query+interview+questions&gs_l=psy-ab.3..0i20i263j0i7i30l4j0j0i30l4.4724.5883..6603...0.2..0.251.1240.0j2j4......0....1..gws-wiz.......0i71j35i304i39j0i13.J0hCo-DlEpQ&ved=0ahUKEwiGsciBoerkAhWcIbcAHQeJBZcQ4dUDCAo&uact=5");
    	
    	
        // Few topics to prepare
        // cycle in a linkedlist, duplicates in linked list, removing duplicates in linked list
        // sorting algorithms--> its not necessary to learn the algorthrims , but knowing about them would be helpful a
        // also which algorith is better than the other and why ---atleast know the runtime of the sort
        // Recursion
        // Knowing how to make custom datastructure
        // Binary search --also time complexity
        //DFS BFS
        //Hash Table
        
        
        return urls;
	}

	

}
