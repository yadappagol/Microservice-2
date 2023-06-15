package com.microservice.serviceregistry.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.serviceregistry.model.Course;
import com.microservice.serviceregistry.model.Student;
import com.microservice.serviceregistry.model.StudentDetails;
import com.microservice.serviceregistry.repository.StudentRepository;

import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ApiCall apiCall;

	@Autowired
	private ApiCallUsingWebClient apiCallUsingWebClient;

	@Override
	public StudentDetails getById(int id) {
		// getting student from table by passing id
		Student std = studentRepository.findById(id).get();

		// getting course from course-microservice by call API
		Course course = apiCall.getCourseDetails(std.getCourseId());

		StudentDetails stdDetails = new StudentDetails();
		BeanUtils.copyProperties(std, stdDetails);
		stdDetails.setCourse(course);

		return stdDetails;

	}

	@Override
	public StudentDetails getByIdUsingWebClient(int id) {
		Student std = studentRepository.findById(id).get();
		Mono<Course> courseMono = apiCallUsingWebClient.getCourseDetails(std.getCourseId());
		Course course = courseMono.block();
		StudentDetails stdDetails = new StudentDetails();
		BeanUtils.copyProperties(std, stdDetails);
		stdDetails.setCourse(course);
		return stdDetails;
	}

	@Override
	public Student getByName(String name) {
		return studentRepository.findByStudentName(name);
	}

	@Override
	public boolean save(Student student) {
		studentRepository.save(student);
		return true;
	}

}
