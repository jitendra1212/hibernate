package com.nt.entity;






public class EmployeeDetails {
	
	private int  eid;
	private String  firstName;

	private String  lastName;
	
	private String email;
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	/*private String  mail;

	@Id
	@Column(name="EID",length=10)
	@Type(type="int")
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Column(name="FIRSTNAME",length=20)
	@Type(type="string")
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Column(name="LASTNAME",length=20)
	@Type(type="string")
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Column(name="EMAIL",length=20,unique=true,nullable=false)
	@Type(type="string")
	@Transient
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}*/
}
