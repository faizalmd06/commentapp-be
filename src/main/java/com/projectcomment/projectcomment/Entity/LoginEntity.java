package com.projectcomment.projectcomment.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOGIN")
public class LoginEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column(name="email_id")
    private String emailId;
	@Column(name="password")
	private String password;
	
	@Column(name="secrete_code")
	private String secreteCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecreteCode() {
		return secreteCode;
	}
	public void setSecreteCode(String secreteCode) {
		this.secreteCode = secreteCode;
	}
	
    
}
