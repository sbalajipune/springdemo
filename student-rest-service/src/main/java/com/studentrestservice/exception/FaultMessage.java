package com.studentrestservice.exception;

import java.util.Date;

public class FaultMessage
{
	private Date timestamp;
	private String message;
	
	public FaultMessage(Date timestamp, String message)
	{
		this.timestamp = timestamp;
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
