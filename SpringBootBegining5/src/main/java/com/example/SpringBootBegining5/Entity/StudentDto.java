package com.example.SpringBootBegining5.Entity;

public class StudentDto {
	
	public StudentDto() {
		super();
	}

	public StudentDto(int studentId, String studentName, String studentRoll, String studentMobile, Address address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentRoll = studentRoll;
		this.studentMobile = studentMobile;
		this.address = address;
	}

	private int studentId;
	private String studentName;
	private String studentRoll;
	private String studentMobile;
	
	private Address address;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentRoll() {
		return studentRoll;
	}

	public void setStudentRoll(String studentRoll) {
		this.studentRoll = studentRoll;
	}

	public String getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StudentDto [studentId=" + studentId + ", studentName=" + studentName + ", studentRoll=" + studentRoll
				+ ", studentMobile=" + studentMobile + ", address=" + address + "]";
	}
	
	

}
