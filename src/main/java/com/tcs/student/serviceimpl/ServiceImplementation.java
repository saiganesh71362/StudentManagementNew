package com.tcs.student.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.student.appconstants.AppConstants;
import com.tcs.student.entity.StudentData;
import com.tcs.student.exceptionhandle.EntityNotFoundException;
import com.tcs.student.exceptionhandle.StudentNotFoundException;
import com.tcs.student.repositoy.StudentRepository;
import com.tcs.student.service.StudentService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceImplementation  implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public String addNewStudent(StudentData studentData)
	{
	    if (studentData.getId() == null) {
	        StudentData savedStudent = studentRepository.save(studentData);
	        return AppConstants.NEW_STUDENT_CREATE + savedStudent.getId();
	    } else {
	        Optional<StudentData> byId = studentRepository.findById(studentData.getId());
	        if (byId.isPresent()) {
	            return AppConstants.STUDENT_ID_ALREADY_EXIST + studentData.getId();
	        } else {
	            StudentData savedStudent = studentRepository.save(studentData);
	            return AppConstants.NEW_STUDENT_CREATE + savedStudent.getId();
	        }  
	    }
	}

	@Override
	public List<StudentData> getAllStudents() {
		List<StudentData> all = studentRepository.findAll();
		return all;
	}

	//   44 line exception change to custom exception
	@Override
	public StudentData getStudentById(Integer id) throws Exception {
	    Optional<StudentData> byId = studentRepository.findById(id);
	    if (byId.isPresent()) {
	        return byId.get();
	    } else {
	        throw new StudentNotFoundException(AppConstants.STUDENT_ID_NOT_FOUND + id);
	    }
	}
	
	
//	@Override
//	public StudentData getStudentById(Integer id) {
//	    return studentRepository.findById(id)
//	        .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
//	}



	@Override
	public StudentData updateStudentById(StudentData studentData, Integer id) throws Exception {
	    Optional<StudentData> existingStudent = studentRepository.findById(id);
	    if (existingStudent.isPresent()) {
	        StudentData updatedStudent = existingStudent.get();
	        updatedStudent.setName(studentData.getName()); // Update other fields as necessary
	        updatedStudent.setContact(studentData.getContact());   // Example fields
	        updatedStudent.setAddress(studentData.getAddress());
	        updatedStudent.setBranch(studentData.getBranch());
	        updatedStudent.setJoinYear(studentData.getJoinYear());
	        // Add other fields to update here
	        return studentRepository.save(updatedStudent);
	    } else {
	        throw new EntityNotFoundException(AppConstants.STUDENT_ID_NOT_FOUND + id);
	        
//	        EntityNotFoundException
	    }
	}
	

	@Override
	public String deleteStudentById(Integer id) {
		
		Optional<StudentData> byId = studentRepository.findById(id);
		if(byId.isPresent())
		{
			studentRepository.deleteById(id);
			return AppConstants.DELETE_STUDENT+id;
		}
		return AppConstants.NO_RECORDS+id;
		
	}


}
