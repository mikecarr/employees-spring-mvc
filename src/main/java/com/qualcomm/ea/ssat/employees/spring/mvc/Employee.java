package com.qualcomm.ea.ssat.employees.spring.mvc;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author mcarr
 *
 */
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private Date birthday;
	
	private String socialSecurityNumber;
	
	private String employeeType;
	
	private int departmentNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public int getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", birthday=" + birthday
				+ ", socialSecurityNumber=" + socialSecurityNumber
				+ ", employeeType=" + employeeType + ", departmentNumber="
				+ departmentNumber + "]";
	}
	
}
