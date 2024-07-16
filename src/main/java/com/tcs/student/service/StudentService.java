package com.tcs.student.service;

import java.util.List;

import com.tcs.student.entity.StudentData;

public interface StudentService 
{
	public String addNewStudent( StudentData studentData);
	public List<StudentData> getAllStudents();
	public StudentData getStudentById(Integer id);
	public String updateStudentById(StudentData studentData , Integer id);
	public String deleteStudentById(Integer id);
	public String deleteAllStudents();

}
