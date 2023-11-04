package com.example.SpringBootBegining5.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SchoolReport {
	
	public SchoolReport() {
		super();
	}

	public SchoolReport(int schoolReportId, String schoolReportYear, List<SchoolClassReport> schoolClassReport) {
		super();
		this.schoolReportId = schoolReportId;
		this.schoolReportYear = schoolReportYear;
		this.schoolClassReport = schoolClassReport;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int schoolReportId;
	private String schoolReportYear;
	
	@OneToMany
	private List<SchoolClassReport> schoolClassReport;

	public int getSchoolReportId() {
		return schoolReportId;
	}

	public void setSchoolReportId(int schoolReportId) {
		this.schoolReportId = schoolReportId;
	}

	public String getSchoolReportYear() {
		return schoolReportYear;
	}

	public void setSchoolReportYear(String schoolReportYear) {
		this.schoolReportYear = schoolReportYear;
	}

	public List<SchoolClassReport> getSchoolClassReport() {
		return schoolClassReport;
	}

	public void setSchoolClassReport(List<SchoolClassReport> schoolClassReport) {
		this.schoolClassReport = schoolClassReport;
	}

	@Override
	public String toString() {
		return "SchoolReport [schoolReportId=" + schoolReportId + ", schoolReportYear=" + schoolReportYear
				+ ", schoolClassReport=" + schoolClassReport + "]";
	}

}
