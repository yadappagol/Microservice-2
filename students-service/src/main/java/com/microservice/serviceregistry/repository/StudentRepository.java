package com.microservice.serviceregistry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.serviceregistry.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Student findByStudentName(String name);
}
