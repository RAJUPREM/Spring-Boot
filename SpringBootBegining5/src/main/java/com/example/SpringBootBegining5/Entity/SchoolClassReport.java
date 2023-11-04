package com.example.SpringBootBegining5.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SchoolClassReport {
	
	
	public SchoolClassReport() {
		super();
	}

	public SchoolClassReport(int schoolClassReportId, String schoolClassReportYear, SchoolClass schoolClass) {
		super();
		this.schoolClassReportId = schoolClassReportId;
		this.schoolClassReportYear = schoolClassReportYear;
		this.schoolClass = schoolClass;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int schoolClassReportId;
	private String schoolClassReportYear;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private SchoolClass schoolClass;

	public int getSchoolClassReportId() {
		return schoolClassReportId;
	}

	public void setSchoolClassReportId(int schoolClassReportId) {
		this.schoolClassReportId = schoolClassReportId;
	}

	public String getSchoolClassReportYear() {
		return schoolClassReportYear;
	}

	public void setSchoolClassReportYear(String schoolClassReportYear) {
		this.schoolClassReportYear = schoolClassReportYear;
	}

	public SchoolClass getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}

	@Override
	public String toString() {
		return "SchoolClassReport [schoolClassReportId=" + schoolClassReportId + ", schoolClassReportYear="
				+ schoolClassReportYear + ", schoolClass=" + schoolClass + "]";
	}

}
