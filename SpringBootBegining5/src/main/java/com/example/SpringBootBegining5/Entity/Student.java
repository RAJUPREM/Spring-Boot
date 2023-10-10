package com.example.SpringBootBegining5.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Student {

	public Student(int studentId, String studentName, String studentRoll, String studentMobile, String className,
			Result result, Address address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentRoll = studentRoll;
		this.studentMobile = studentMobile;
		this.className = className;
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
	
	
	private String className;
	
	
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentRoll=" + studentRoll
				+ ", studentMobile=" + studentMobile + ", className=" + className + ", result=" + result.toString() + ", address="
				+ address + "]";
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	

	
	
	
	
	

}
