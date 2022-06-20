package com.yedam.java.emp;

import java.sql.Date;

public class Employee { // vo -한 행을 나타냄

	//필드 - 테이블에 해당하는 칼럼
	private int employeeId; //언더바 사용하지 않음, 뒤에있는 첫번째 단어가 대문자로 변함
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commission;
	private int managerId;
	private int departmentId;
	
	
	
	/*default constructor - 기본생성자
	 * public employee(){}
	 * 자바가 알아서 넣어줌
	 */
	
	
	//getter,setter

	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Date getHireDate() {
		return hireDate;
	}


	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	public String getJobId() {
		return jobId;
	}


	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public double getCommission() {
		return commission;
	}


	public void setCommission(double commission) {
		this.commission = commission;
	}


	public int getManagerId() {
		return managerId;
	}


	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary="
				+ salary + ", commission=" + commission + ", managerId=" + managerId + ", departmentId=" + departmentId
				+ "]";
	}

}
