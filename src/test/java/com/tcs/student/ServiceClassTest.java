package com.tcs.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.tcs.student.appconstants.AppConstants;
import com.tcs.student.entity.StudentData;
import com.tcs.student.exceptionhandle.StudentNotFoundException;
import com.tcs.student.repositoy.StudentRepository;
import com.tcs.student.serviceimpl.ServiceImplementation;

@SpringBootTest
class ServiceClassTest {

	@Mock
	StudentRepository studentRepository;

	@InjectMocks
	ServiceImplementation serviceImplementation;

	@Test
	@Order(1)
	void test_addNewStudent() {
		StudentData student1 = new StudentData(1, // id
				"SAIGANESH PELLAKURU", // name
				8186058001L, // contact
				"BANGARUPET VENKATATGIRI NELLORE", // address
				2017l, // joinYear
				"BSC", // branch
				LocalDateTime.parse("2024-07-17T14:49:53.959617"), // createdDate
				LocalDateTime.parse("2024-07-17T15:31:27.985851") // updatedDate
		);
		// Mock
		when(studentRepository.save(student1)).thenReturn(student1);
		assertEquals(AppConstants.NEW_STUDENT_CREATE + 1, serviceImplementation.addNewStudent(student1));
	}

	@Test
	@Order(2)
	void test_addNewStudentAlreadyExixt() {
		StudentData student1 = new StudentData(1, // id
				"SAIGANESH PELLAKURU", // name
				8186058001L, // contact
				"BANGARUPET VENKATATGIRI NELLORE", // address
				2017l, // joinYear
				"BSC", // branch
				LocalDateTime.parse("2024-07-17T14:49:53.959617"), // createdDate
				LocalDateTime.parse("2024-07-17T15:31:27.985851") // updatedDate
		);

		when(studentRepository.findById(1)).thenReturn(Optional.of(student1));
		String newStudent = serviceImplementation.addNewStudent(student1);
		assertEquals(AppConstants.STUDENT_ID_ALREADY_EXIST + 1, newStudent);

	}

	@Test
	@Order(3)
	void test_getAllStudents() {
		ArrayList<StudentData> studentList = new ArrayList<StudentData>();

		StudentData student1 = new StudentData(1, // id
				"SAIGANESH PELLAKURU", // name
				8186058001L, // contact
				"BANGARUPET VENKATATGIRI NELLORE", // address
				2017l, // joinYear
				"BSC", // branch
				LocalDateTime.parse("2024-07-17T14:49:53.959617"), // createdDate
				LocalDateTime.parse("2024-07-17T15:31:27.985851") // updatedDate
		);

		StudentData student2 = new StudentData(1, // id
				"SUPRIYA PELLAKURU", // name
				919101919L, // contact
				"BANGARUPET VENKATATGIRI NELLORE", // address
				2017l, // joinYear
				"BSC", // branch
				LocalDateTime.parse("2024-07-17T14:49:53.959617"), // createdDate
				LocalDateTime.parse("2024-07-17T15:31:27.985851") // updatedDate
		);
		studentList.add(student1);
		studentList.add(student2);

		when(studentRepository.findAll()).thenReturn(studentList);
		assertEquals(2, serviceImplementation.getAllStudents().size());
	}

	@Test
	@Order(4)
	void test_getStudnetById() throws Exception {
		StudentData student1 = new StudentData(1, // id
				"SAIGANESH PELLAKURU", // name
				8186058001L, // contact
				"BANGARUPET VENKATATGIRI NELLORE", // address
				2017l, // joinYear
				"BSC", // branch
				LocalDateTime.parse("2024-07-17T14:49:53.959617"), // createdDate
				LocalDateTime.parse("2024-07-17T15:31:27.985851") // updatedDate
		);

		when(studentRepository.findById(1)).thenReturn(Optional.of(student1));
		assertEquals(student1, serviceImplementation.getStudentById(1));
	}

	@Test
	@Order(5)
	void test_getStudnetById_NotFound() {
		StudentData student1 = new StudentData(1, // id
				"SAIGANESH PELLAKURU", // name
				8186058001L, // contact
				"BANGARUPET VENKATATGIRI NELLORE", // address
				2017l, // joinYear
				"BSC", // branch
				LocalDateTime.parse("2024-07-17T14:49:53.959617"), // createdDate
				LocalDateTime.parse("2024-07-17T15:31:27.985851") // updatedDate
		);

		when(studentRepository.findById(1)).thenReturn(Optional.empty());

		StudentNotFoundException assertThrows2 = assertThrows(StudentNotFoundException.class,
				() -> serviceImplementation.getStudentById(1));

		assertEquals(AppConstants.STUDENT_ID_NOT_FOUND + 1, assertThrows2.getMessage());
	}

	@Test
	@Order(6)
	void test_updateStudentById() throws Exception {
		StudentData existingStudent = new StudentData();
		existingStudent.setId(1);
		existingStudent.setName("John Doe");
		existingStudent.setContact(1234567890L);
		existingStudent.setAddress("123 Main St");
		existingStudent.setBranch("Science");
		existingStudent.setJoinYear(2020L);

		StudentData updatedStudentData = new StudentData();
		updatedStudentData.setName("Jane Doe");
		updatedStudentData.setContact(9876543211L);
		updatedStudentData.setAddress("456 Elm St");
		updatedStudentData.setBranch("Arts");
		updatedStudentData.setJoinYear(2021L);

		when(studentRepository.findById(1)).thenReturn(Optional.of(existingStudent));

		when(studentRepository.save(existingStudent)).thenReturn(existingStudent);

		StudentData updateStudentById = serviceImplementation.updateStudentById(updatedStudentData, 1);

		assertNotNull(updateStudentById);
		assertEquals(updatedStudentData.getName(), updateStudentById.getName());
		assertEquals(updatedStudentData.getContact(), updateStudentById.getContact());
		assertEquals(updatedStudentData.getAddress(), updateStudentById.getAddress());
		assertEquals(updatedStudentData.getBranch(), updateStudentById.getBranch());
		assertEquals(updatedStudentData.getJoinYear(), updateStudentById.getJoinYear());
	}

	@Test
	@Order(7)
	void test_updateStudentById_Faild() {
		StudentData student1 = new StudentData(1, // id
				"SAIGANESH PELLAKURU", // name
				8186058001L, // contact
				"BANGARUPET VENKATATGIRI NELLORE", // address
				2017l, // joinYear
				"BSC", // branch
				LocalDateTime.parse("2024-07-17T14:49:53.959617"), // createdDate
				LocalDateTime.parse("2024-07-17T15:31:27.985851") // updatedDate
		);
		when(studentRepository.findById(1)).thenReturn(Optional.empty());

		StudentNotFoundException assertThrows2 = assertThrows(StudentNotFoundException.class, () -> {
			serviceImplementation.updateStudentById(student1, 1);
		});
		assertEquals(AppConstants.STUDENT_ID_NOT_FOUND + 1, assertThrows2.getMessage());
	}

	@Test
	@Order(8)
	void test_deleteStudentById() throws StudentNotFoundException {
		StudentData student1 = new StudentData(1, // id
				"SAIGANESH PELLAKURU", // name
				8186058001L, // contact
				"BANGARUPET VENKATATGIRI NELLORE", // address
				2017l, // joinYear
				"BSC", // branch
				LocalDateTime.parse("2024-07-17T14:49:53.959617"), // createdDate
				LocalDateTime.parse("2024-07-17T15:31:27.985851") // updatedDate
		);

		when(studentRepository.findById(1)).thenReturn(Optional.of(student1));
		assertEquals("delete Success Fully :" + 1, serviceImplementation.deleteStudentById(1));
	}

	@Test
	@Order(9)
	void test_deleteStudentById_Faild() {
		StudentData student1 = new StudentData(1, // id
				"SAIGANESH PELLAKURU", // name
				8186058001L, // contact
				"BANGARUPET VENKATATGIRI NELLORE", // address
				2017l, // joinYear
				"BSC", // branch
				LocalDateTime.parse("2024-07-17T14:49:53.959617"), // createdDate
				LocalDateTime.parse("2024-07-17T15:31:27.985851") // updatedDate
		);
		when(studentRepository.findById(1)).thenReturn(Optional.empty());
		StudentNotFoundException assertThrows2 = assertThrows(StudentNotFoundException.class, () -> {
			serviceImplementation.deleteStudentById(1);
		});

		assertEquals("There is no record with ID: " + 1, assertThrows2.getMessage());

	}
}
