package com.example.SpringBootBegining5.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.example.SpringBootBegining5.Repsitory.TeacherRepository;
//resource/pojo/entity/bean

@Entity
public class Teacher {
	
	
	
	public Teacher(int teacherId, String teacherName, Address address, String teacherMobile, String teacherSubjectName,
			SchoolClass schoolClass) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.address = address;
		this.teacherMobile = teacherMobile;
		this.teacherSubjectName = teacherSubjectName;
		this.schoolClass = schoolClass;
	}
	public Teacher() {
		super();
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teacherId;
	private String teacherName;
	@Embedded
	private Address address;
	private String teacherMobile;
	private String teacherSubjectName;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonManagedReference
	private SchoolClass schoolClass;
	
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
	public SchoolClass getSchoolClass() {
		return schoolClass;
	}
	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", address=" + address
				+ ", teacherMobile=" + teacherMobile + ", teacherSubjectName=" + teacherSubjectName + ", schoolClass="
				+ schoolClass + "]";
	}
	
	
	
	

}
