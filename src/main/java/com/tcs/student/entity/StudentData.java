package com.tcs.student.entity;

import java.time.LocalDateTime;

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
	private Integer id;
	@NotNull(message =  " Enter Studnet Name")
	@Size(min =1, max = 20 , message = "Student Name Must And Should Be 10 to 20 Chars Only")
	private String name;
	@NotNull(message = "Enter Student Contact Details")
//	@Size(min =1, max=20, message = "Contact Number Allowed Only 10 Digits")
	private Long contact;
	@NotNull(message = "Enter Student Address")
	@Size(min =1, max = 100, message =  "Student Address 10 to 100 chars")
	private String address;
	@NotNull(message = "Enter Student Join Year")
//	@Size(min =1 ,max = 8 , message = "Join year allow only 4 letters")
	private Long joinYear;
	@NotNull(message = "EnterStudent Branch")
	@Size(min =1 , max = 40, message = "Student Branch Must And Should Be 20 to 40 Chars")
	private String branch;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime creatdDate;
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDateTime updatedDate;

}
