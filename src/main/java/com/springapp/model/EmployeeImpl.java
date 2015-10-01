package com.springapp.model;

public class EmployeeImpl {

	private int employeeId;
	private String title, forename, surname;
	private Address address;
	private Department department; //is this correct?
	private String mobileNumber, landlineNumber;
	private String login;
	private String password;
	private int securityLevel;

	public EmployeeImpl(int employeeId, String title, String forename, String surname, Address address, Department department, String mobileNumber, String landlineNumber, String login, String password, int securityLevel){
		this.employeeId = employeeId;
		this.title = title;
		this.forename = forename;
		this.surname = surname;
		this.address = address;
		this.department = department;
		this.mobileNumber = mobileNumber;
		this.landlineNumber = landlineNumber;
		this.login = login;
		this.password = password;
		this.securityLevel = securityLevel;
	}

	public EmployeeImpl(String title, String forename, String surname, Address address, Department department, String mobileNumber, String landlineNumber, String login, String password, int securityLevel){
		this.title = title;
		this.forename = forename;
		this.surname = surname;
		this.address = address;
		this.department = department;
		this.mobileNumber = mobileNumber;
		this.landlineNumber = landlineNumber;
		this.login = login;
		this.password = password;
		this.securityLevel = securityLevel;
	}

	//EmployeeId
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	//gName
	public String getName() { return title + " " + forename + " " + surname;}
	public void setName(String title, String forename, String surname) {
		this.title = title;
		this.forename = forename;
		this.surname = surname;
	}

	//Address
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	//Department
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	//MobileNumber
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	//LandlineNumber
	public String getLandlineNumber() {
		return landlineNumber;
	}
	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}

	//Login
	public String getLogin() {
		return this.login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	//Password
	public void setPassword(String password) {
		this.password = password;
	}

	//SecurityLevel
	public int getSecurityLevel() {
		return securityLevel;
	}
	public void setSecurityLevel(int securityLevel) {
		this.securityLevel = securityLevel;
	}
}
