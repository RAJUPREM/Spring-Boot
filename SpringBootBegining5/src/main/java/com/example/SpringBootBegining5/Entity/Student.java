package com.example.SpringBootBegining5.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Student {

	
	public Student(int studentId, String studentName, String studentRoll, String studentMobile, SchoolClass schoolClass,
			Result result, Address address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentRoll = studentRoll;
		this.studentMobile = studentMobile;
		this.schoolClass = schoolClass;
		this.result = result;
		this.address = address;
	}
	public Student() {
		super();
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	private String studentRoll;
	private String studentMobile;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonManagedReference
	private SchoolClass schoolClass;
	
	
	@JsonManagedReference
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="result_id")
	private Result result;
	//@OneToOne(cascade=CascadeType.ALL)
	@Embedded
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
	public SchoolClass getSchoolClass() {
		return schoolClass;
	}
	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentRoll=" + studentRoll
				+ ", studentMobile=" + studentMobile + ", schoolClass=" + schoolClass + ", result=" + result
				+ ", address=" + address + "]";
	}

	
	
	

	
	
	
	
	

}
