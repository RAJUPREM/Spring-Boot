package com.example.SpringBootBegining5.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class PerDayAttendance {
	
	public PerDayAttendance(String date, SchoolClass schoolClass, List<Student> listStudentsAttandance) {
		super();
		this.date = date;
		this.schoolClass = schoolClass;
		this.listStudentsAttandance = listStudentsAttandance;
	}

	public PerDayAttendance() {
		super();
	}

	@Id
	private String date;
	
	@OneToOne(cascade=CascadeType.ALL)
	private SchoolClass schoolClass;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Student> listStudentsAttandance;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public SchoolClass getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}

	public List<Student> getListStudentsAttandance() {
		return listStudentsAttandance;
	}

	public void setListStudentsAttandance(List<Student> listStudentsAttandance) {
		this.listStudentsAttandance = listStudentsAttandance;
	}

	@Override
	public String toString() {
		return "PerDayAttendance [date=" + date + ", schoolClass=" + schoolClass + ", listStudentsAttandance="
				+ listStudentsAttandance + "]";
	}

	


	
	
	

}
