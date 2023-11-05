package com.example.SpringBootBegining5.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class SchoolClass {
	
	public SchoolClass() {
		super();
	}


	public SchoolClass(String schoolClassId, String schoolClassStandard, String schoolClassSection,
			SchoolSubject schoolSubject, List<Student> students, List<Teacher> teachers) {
		super();
		this.schoolClassId = schoolClassId;
		this.schoolClassStandard = schoolClassStandard;
		this.schoolClassSection = schoolClassSection;
		this.schoolSubject = schoolSubject;
		this.students = students;
		this.teachers = teachers;
	}


	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String schoolClassId;
	private String schoolClassStandard;
	private String schoolClassSection;
	
	@Embedded
	private SchoolSubject schoolSubject;
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="schoolClass")
	@JsonBackReference
	private List<Student> students;
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="schoolClass")
	@JsonBackReference
	private List<Teacher> teachers;


	public String getSchoolClassId() {
		return schoolClassId;
	}


	public void setSchoolClassId() {
		this.schoolClassId = this.getSchoolClassStandard()+"-"+this.getSchoolClassSection();
	}


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


	public SchoolSubject getSchoolSubject() {
		return schoolSubject;
	}


	public void setSchoolSubject(SchoolSubject schoolSubject) {
		this.schoolSubject = schoolSubject;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public List<Teacher> getTeachers() {
		return teachers;
	}


	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}


	@Override
	public String toString() {
		return "SchoolClass [schoolClassId=" + schoolClassId + ", schoolClassStandard=" + schoolClassStandard
				+ ", schoolClassSection=" + schoolClassSection + ", schoolSubject=" + schoolSubject + ", students="
				+ students + ", teachers=" + teachers + "]";
	}

}
