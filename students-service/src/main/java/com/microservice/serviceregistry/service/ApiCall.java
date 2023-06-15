package com.microservice.serviceregistry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.serviceregistry.model.Course;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ApiCall {

	@Autowired
	RestTemplate restTemplate;

	private static final String COURSE_MICROSEcRVICE_BASEURL = "http://course-service";

	@CircuitBreaker(name = "example", fallbackMethod = "fallback")
	public Course getCourseDetails(int courseId) {
		Course course = restTemplate.getForObject(COURSE_MICROSEcRVICE_BASEURL + "/course/id?id={courseId}",
				Course.class, courseId);
		return course;
	}

	public Course fallback(Exception exception) {
		Course course = new Course();
		course.setId(1);
		course.setName("common-course");
		course.setDuration(2);
		return course;
	}

}
