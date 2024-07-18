package com.tcs.student.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tcs.student.entity.StudentData;

@Repository
public interface StudentService 
{
	public String addNewStudent( StudentData studentData);
	public List<StudentData> getAllStudents();
	public StudentData getStudentById(Integer id) throws Exception;
	public StudentData updateStudentById(StudentData studentData , Integer id) throws Exception;
	public String deleteStudentById(Integer id);
	
//	public void deleteAllStudents();

}
