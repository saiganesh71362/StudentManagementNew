package com.tcs.student.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "StudentsData")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer id;
	@NotNull(message =  " Enter Studnet Name")
	@Size(min = 10, max = 20 , message = "Student Name Must And Should Be 10 to 20 Chars Only")
	private String name;
	@NotNull(message = "Enter Student Contact Details")
	@Size(min = 10, max=10, message = "Contact Number Allowed Only 10 Digits")
	private Long contact;
	@NotNull(message = "Enter Student Address")
	@Size(min = 10, max = 100, message =  "Student Address 10 to 100 chars")
	private String address;
	@NotNull(message = "Enter Student Join Year")
	@Size(min = 4, max = 4 , message = "Join year allow only 4 letters")
	private Long joinYear;
	@NotNull(message = "EnterStudent Branch")
	@Size(min = 20 , max = 40, message = "Student Branch Must And Should Be 20 to 40 Chars")
	private String branch;
	@NotNull
	private String createdBy;
	@NotNull
	private String updatedBy;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate creatdDate;
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updatedDate;

}
