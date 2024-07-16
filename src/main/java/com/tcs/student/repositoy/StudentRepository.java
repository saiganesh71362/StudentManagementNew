package com.tcs.student.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tcs.student.entity.StudentData;

public interface StudentRepository extends JpaRepository<StudentData, Integer> 
{
	// native sql queries
	
	 @Query(value = "Select * from StudentData" , nativeQuery = true)
	 public List<StudentData>getAllStudent();

}
