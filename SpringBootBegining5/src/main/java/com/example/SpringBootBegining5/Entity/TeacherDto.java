package com.example.SpringBootBegining5.Entity;

import javax.persistence.Embedded;

public class TeacherDto {
	
	public TeacherDto() {
		super();
	}
	public TeacherDto(int teacherId, String teacherName, Address address, String teacherMobile,
			String teacherSubjectName) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.address = address;
		this.teacherMobile = teacherMobile;
		this.teacherSubjectName = teacherSubjectName;
	}
	private int teacherId;
	private String teacherName;
	private Address address;
	private String teacherMobile;
	private String teacherSubjectName;
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getTeacherMobile() {
		return teacherMobile;
	}
	public void setTeacherMobile(String teacherMobile) {
		this.teacherMobile = teacherMobile;
	}
	public String getTeacherSubjectName() {
		return teacherSubjectName;
	}
	public void setTeacherSubjectName(String teacherSubjectName) {
		this.teacherSubjectName = teacherSubjectName;
	}
	@Override
	public String toString() {
		return "TeacherDto [teacherId=" + teacherId + ", teacherName=" + teacherName + ", address=" + address
				+ ", teacherMobile=" + teacherMobile + ", teacherSubjectName=" + teacherSubjectName + "]";
	}

}
