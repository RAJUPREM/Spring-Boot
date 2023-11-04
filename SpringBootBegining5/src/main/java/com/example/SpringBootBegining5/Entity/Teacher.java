package com.example.SpringBootBegining5.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import com.example.SpringBootBegining5.Repsitory.TeacherRepository;
//resource/pojo/entity/bean

@Entity
public class Teacher {
	
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(String teacherUsername, int teacherId, String teacherName, String teacherPassword,
			String teacherMobile,String teacherSubjectName) {
		super();
		this.teacherUsername = teacherUsername;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherPassword = teacherPassword;
		this.teacherMobile = teacherMobile;
		this.teacherSubjectName=teacherSubjectName;
	}
	@Id
	private String teacherUsername;
	private int teacherId;
	private String teacherName;
	private String teacherPassword;
	private String teacherMobile;
	private String teacherSubjectName;
	public String getTeacherUsername() {
		return teacherUsername;
	}
	public void setTeacherUsername(String teacherUsername) {
		this.teacherUsername = teacherUsername;
	}
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
	public String getTeacherPassword() {
		return teacherPassword;
	}
	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
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
		return "Teacher [teacherUsername=" + teacherUsername + ", teacherId=" + teacherId + ", teacherName="
				+ teacherName + ", teacherPassword=" + teacherPassword + ", teacherMobile=" + teacherMobile
				+ ", teacherSubjectName=" + teacherSubjectName + "]";
	}
	

}
