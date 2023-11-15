package com.example.SpringBootBegining5.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class MonthlyAttendance {
	
	public MonthlyAttendance(String yearMonthAtten, SchoolClass schoolClass, List<PerDayAttendance> perDayAttendance) {
		super();
		this.yearMonthAtten = yearMonthAtten;
		this.schoolClass = schoolClass;
		this.perDayAttendance = perDayAttendance;
	}

	public MonthlyAttendance() {
		super();
	}

	public MonthlyAttendance(String yearMonthAtten, List<PerDayAttendance> perDayAttendance) {
		super();
		this.yearMonthAtten = yearMonthAtten;
		this.perDayAttendance = perDayAttendance;
	}

	@Id
	private String yearMonthAtten;
	
	@OneToOne(cascade=CascadeType.ALL)
	private SchoolClass schoolClass;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<PerDayAttendance> perDayAttendance;

	public String getYearMonthAtten() {
		return yearMonthAtten;
	}

	public void setYearMonthAtten(String yearMonthAtten) {
		this.yearMonthAtten = yearMonthAtten;
	}

	public SchoolClass getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}

	public List<PerDayAttendance> getPerDayAttendance() {
		return perDayAttendance;
	}

	public void setPerDayAttendance(List<PerDayAttendance> perDayAttendance) {
		this.perDayAttendance = perDayAttendance;
	}

	

}
