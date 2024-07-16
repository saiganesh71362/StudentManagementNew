package com.tcs.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.student.entity.StudentData;
import com.tcs.student.service.StudentService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentController
{
	@Autowired
	private StudentService studentService;
	
	public ResponseEntity<StudentData> addnewStudent(@RequestBody StudentData studentData)
	{
		StudentData newStudent = studentService.addNewStudent(studentData);
		return new ResponseEntity<StudentData>(newStudent,HttpStatus.CREATED);
	}

}
