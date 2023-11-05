package com.example.SpringBootBegining5.Entity;

import java.util.Arrays;

public class SchoolClassDto {
	
	public SchoolClassDto(String schoolClassStandard, String schoolClassSection, int[] studentId, int[] teacherId) {
		super();
		this.schoolClassStandard = schoolClassStandard;
		this.schoolClassSection = schoolClassSection;
		this.studentId = studentId;
		this.teacherId = teacherId;
	}
	public SchoolClassDto() {
		super();
	}
	public SchoolClassDto(String schoolClassStandard, String schoolClassSection) {
		super();
		this.schoolClassStandard = schoolClassStandard;
		this.schoolClassSection = schoolClassSection;
	}
	private String schoolClassStandard;
	private String schoolClassSection;
	
	private int [] studentId;
	private int [] teacherId;
	public String getSchoolClassStandard() {
		return schoolClassStandard;
	}
	public void setSchoolClassStandard(String schoolClassStandard) {
		this.schoolClassStandard = schoolClassStandard;
	}
	public String getSchoolClassSection() {
		return schoolClassSection;
	}
	public void setSchoolClassSection(String schoolClassSection) {
		this.schoolClassSection = schoolClassSection;
	}
	public int[] getStudentId() {
		return studentId;
	}
	public void setStudentId(int[] studentId) {
		this.studentId = studentId;
	}
	public int[] getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int[] teacherId) {
		this.teacherId = teacherId;
	}
	@Override
	public String toString() {
		return "SchoolClassDto [schoolClassStandard=" + schoolClassStandard + ", schoolClassSection="
				+ schoolClassSection + ", studentId=" + Arrays.toString(studentId) + ", teacherId="
				+ Arrays.toString(teacherId) + "]";
	}

}
