package com.microservice.serviceregistry.service;

import com.microservice.serviceregistry.model.Student;
import com.microservice.serviceregistry.model.StudentDetails;

public interface StudentService {

	StudentDetails getById(int id);

	Student getByName(String name);

	boolean save(Student student);

	StudentDetails getByIdUsingWebClient(int id);


}
	