package com.example.SpringBootBegining5.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Attendance {
	
	

	public Attendance() {
		super();
	}

	public Attendance(int attendanceId, SchoolClass schoolClass, List<MonthlyAttendance> monthlyAttendance) {
		super();
		this.attendanceId = attendanceId;
		this.schoolClass = schoolClass;
		this.monthlyAttendance = monthlyAttendance;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int attendanceId;
	
	@OneToOne(cascade=CascadeType.ALL)
	private SchoolClass schoolClass;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<MonthlyAttendance> monthlyAttendance;

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public SchoolClass getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}

	public List<MonthlyAttendance> getMonthlyAttendance() {
		return monthlyAttendance;
	}

	public void setMonthlyAttendance(List<MonthlyAttendance> monthlyAttendance) {
		this.monthlyAttendance = monthlyAttendance;
	}

	@Override
	public String toString() {
		return "Attendance [attendanceId=" + attendanceId + ", schoolClass=" + schoolClass + ", monthlyAttendance="
				+ monthlyAttendance + "]";
	}

	

}
