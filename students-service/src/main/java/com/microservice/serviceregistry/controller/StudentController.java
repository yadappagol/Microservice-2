package com.microservice.serviceregistry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.serviceregistry.model.Student;
import com.microservice.serviceregistry.model.StudentDetails;
import com.microservice.serviceregistry.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService stdService;

//	@GetMapping("/id")
//	public StudentDetails getById(@RequestParam(value = "id", defaultValue = "1") int id) {
//		return stdService.getById(id);
//	}

	@GetMapping("/{id}")
	public StudentDetails getById(@PathVariable int id) {
		return stdService.getById(id);
	}

	@GetMapping("/webclientid")
	public StudentDetails getByIdUsingWebClient(@RequestParam(value = "id", defaultValue = "1") int id) {
		return stdService.getByIdUsingWebClient(id);
	}

	@GetMapping("/name")
	public Student getByName(@RequestParam(value = "name", defaultValue = "Dundappa") String name) {
		return stdService.getByName(name);
	}

	@PostMapping("/save")
	public boolean save(@RequestBody Student student) {
		stdService.save(student);
		return true;
	}

}
