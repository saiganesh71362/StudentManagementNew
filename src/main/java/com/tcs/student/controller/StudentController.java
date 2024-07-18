package com.tcs.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/newStudent")
	public ResponseEntity<String> addnewStudent(@RequestBody StudentData studentData) {
		String newStudent = studentService.addNewStudent(studentData);
		return new ResponseEntity<String>(newStudent, HttpStatus.CREATED);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<StudentData> getStudentById(@PathVariable Integer id) throws Exception
	{
		StudentData studentById = studentService.getStudentById(id);
		return new ResponseEntity<StudentData>(studentById,HttpStatus.OK);
		
	}
	@GetMapping("/allStudents")
    public ResponseEntity<List<StudentData>>	getAllStudents()
	{
		List<StudentData> allStudents = studentService.getAllStudents();
		return new ResponseEntity<List<StudentData>>(allStudents,HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<StudentData> updateStudent(@RequestBody StudentData studentData, @PathVariable Integer id ) throws Exception
	{
		StudentData updateStudentById = studentService.updateStudentById(studentData, id);
		
		return new ResponseEntity<StudentData>(updateStudentById,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>  deleteStudentById(@PathVariable Integer id)
	{
		 String deleteStudentById = studentService.deleteStudentById(id);
		 
		 return new ResponseEntity<String>(deleteStudentById,HttpStatus.OK);
	}

}
