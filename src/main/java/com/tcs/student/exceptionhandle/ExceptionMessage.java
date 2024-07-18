package com.tcs.student.exceptionhandle;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExceptionMessage
{
	private Date timeStamp;
	private String message;
	private String details;

}
