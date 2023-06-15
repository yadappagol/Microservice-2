package com.microservice.serviceregistry.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetails implements Serializable {
	private int studnetId;
	private String studentName;
	private Long mobileNo;
	private int courseId;
	private Course course;
}
