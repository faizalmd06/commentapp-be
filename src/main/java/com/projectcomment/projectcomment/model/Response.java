package com.projectcomment.projectcomment.model;

import java.util.List;

public class Response {
	private String statuscode;
	private String message;
	private List<?> entity;
	public Response(String statuscode, String message, List<?> entity) {
		super();
		this.statuscode = statuscode;
		this.message = message;
		this.entity = entity;
	}
	public Response(String statuscode, String message) {
		super();
		this.statuscode = statuscode;
		this.message = message;
	}
	public String getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<?> getEntity() {
		return entity;
	}
	public void setEntity(List<?> entity) {
		this.entity = entity;
	}
	

}
