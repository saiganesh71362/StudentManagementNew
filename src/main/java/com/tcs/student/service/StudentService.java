package com.tcs.student.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tcs.student.entity.StudentData;
import com.tcs.student.exceptionhandle.StudentNotFoundException;

@Repository
public interface StudentService 
{
	public String addNewStudent( StudentData studentData);
	public List<StudentData> getAllStudents();
	public StudentData getStudentById(Integer id) throws StudentNotFoundException;
	public StudentData updateStudentById(StudentData studentData , Integer id) throws StudentNotFoundException;
	public String deleteStudentById(Integer id) throws StudentNotFoundException;
	
//	public void deleteAllStudents();

}
