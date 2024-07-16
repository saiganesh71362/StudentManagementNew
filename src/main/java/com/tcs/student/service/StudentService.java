package com.tcs.student.service;

import java.util.List;

import com.tcs.student.entity.StudentData;

public interface StudentService 
{
	public StudentData addNewStudent( StudentData studentData);
	public List<StudentData> getAllStudents();
	public StudentData getStudentById(Integer id) throws Exception;
	public StudentData updateStudentById(StudentData studentData , Integer id) throws Exception;
	public void deleteStudentById(Integer id);
	public void deleteAllStudents();

}
