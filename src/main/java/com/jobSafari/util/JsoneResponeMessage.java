package com.jobSafari.util;

public class JsoneResponeMessage {
 private int id;
 private String message;
 
 public JsoneResponeMessage() {
		
	}
	 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public JsoneResponeMessage(int id, String message) {
	super();
	this.id = id;
	this.message = message;
}

 
}
