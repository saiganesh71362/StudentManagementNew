package com.tcs.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tcs.student.controller.StudentController;
import com.tcs.student.entity.StudentData;
import com.tcs.student.exceptionhandle.StudentNotFoundException;
import com.tcs.student.serviceimpl.ServiceImplementation;

@SpringBootTest
class ControllerClassTest {

	@Mock
	ServiceImplementation serviceImplementation;

	@InjectMocks
	StudentController studentController;

	@Test
	@Order(1)
	void test_addnewStudent() {

		StudentData student1 = new StudentData(1, // id
				"SAIGANESH PELLAKURU", // name
				8186058001L, // contact
				"BANGARUPET VENKATATGIRI NELLORE", // address
				2017l, // joinYear
				"BSC", // branch
				LocalDateTime.parse("2024-07-17T14:49:53.959617"), // createdDate
				LocalDateTime.parse("2024-07-17T15:31:27.985851") // updatedDate
		);

		when(serviceImplementation.addNewStudent(student1)).thenReturn(""); // Mock
		ResponseEntity<String> addnewStudent = studentController.addnewStudent(student1);

		assertEquals(HttpStatus.CREATED, addnewStudent.getStatusCode());
		assertEquals("", addnewStudent.getBody());
	}

	@Test
	@Order(2)
	void test_getStudentById() throws Exception {
		StudentData student1 = new StudentData(1, // id
				"SAIGANESH PELLAKURU", // name
				8186058001L, // contact
				"BANGARUPET VENKATATGIRI NELLORE", // address
				2017l, // joinYear
				"BSC", // branch
				LocalDateTime.parse("2024-07-17T14:49:53.959617"), // createdDate
				LocalDateTime.parse("2024-07-17T15:31:27.985851") // updatedDate
		);
		when(serviceImplementation.getStudentById(1)).thenReturn(student1); // Mock

		ResponseEntity<StudentData> studentById = studentController.getStudentById(1);
		assertEquals(HttpStatus.FOUND, studentById.getStatusCode());
		assertEquals(student1, studentById.getBody());

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

		when(serviceImplementation.getAllStudents()).thenReturn(studentList); // Mock

		ResponseEntity<List<StudentData>> allStudents = studentController.getAllStudents();

		assertEquals(HttpStatus.FOUND, allStudents.getStatusCode());
		assertEquals(2, allStudents.getBody().size());
	}

	@Test
	@Order(4)
	void test_updateStudent() throws Exception {
		StudentData student2 = new StudentData(1, // id
				"SUPRIYA PELLAKURU", // name
				919101919L, // contact
				"BANGARUPET VENKATATGIRI NELLORE", // address
				2017l, // joinYear
				"BSC", // branch
				LocalDateTime.parse("2024-07-17T14:49:53.959617"), // createdDate
				LocalDateTime.parse("2024-07-17T15:31:27.985851") // updatedDate
		);
		when(serviceImplementation.updateStudentById(student2, 1)).thenReturn(student2);

		ResponseEntity<StudentData> updateStudent = studentController.updateStudent(student2, 1);

		assertEquals(HttpStatus.ACCEPTED, updateStudent.getStatusCode());
		assertEquals(student2, updateStudent.getBody());
	}

	@Test
	@Order(5)
	void test_deleteStudentById() throws StudentNotFoundException {
		StudentData student2 = new StudentData(1, // id
				"SUPRIYA PELLAKURU", // name
				919101919L, // contact
				"BANGARUPET VENKATATGIRI NELLORE", // address
				2017l, // joinYear
				"BSC", // branch
				LocalDateTime.parse("2024-07-17T14:49:53.959617"), // createdDate
				LocalDateTime.parse("2024-07-17T15:31:27.985851") // updatedDate
		);
		when(serviceImplementation.deleteStudentById(1)).thenReturn(""); // Mock

		ResponseEntity<String> deleteStudentById = studentController.deleteStudentById(1);

		assertEquals(HttpStatus.OK, deleteStudentById.getStatusCode());
		assertEquals("", deleteStudentById.getBody());

	}

}
