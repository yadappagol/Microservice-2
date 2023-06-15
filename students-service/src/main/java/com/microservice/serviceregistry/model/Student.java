package com.microservice.serviceregistry.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Student_Service")
public class Student implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_Id")
	private int studnetId;
	@Column(name = "student_Name")
	private String studentName;
	@Column(name = "student_MobileNo")
	private Long mobileNo;
	@Column(name = "Course_Id")
	private int courseId;

}
