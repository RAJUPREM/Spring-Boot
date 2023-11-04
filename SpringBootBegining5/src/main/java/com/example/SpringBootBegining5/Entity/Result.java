package com.example.SpringBootBegining5.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Result {
	
	
	public Result(int resultId, Student student, Marks marks, float percentage) {
		super();
		this.resultId = resultId;
		this.student = student;
		this.marks = marks;
		this.percentage = percentage;
	}
	public Result() {
		super();
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int resultId;
	
	@JsonBackReference
	@OneToOne(cascade=CascadeType.ALL,mappedBy="result")
	private Student student;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="marks_id")
	private Marks marks;
	private float percentage;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Marks getMarks() {
		return marks;
	}
	public void setMarks(Marks marks) {
		this.marks = marks;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(Marks marks) {
		float sum=marks.getComputer()+marks.getEnglish()+marks.getHindi()+marks.getMaths()+marks.getScience()+marks.getSst();
		this.percentage=sum/5;
	}
	
	public void setPercentage(float percentage) {
		this.percentage =percentage;
	}
	
	public int getResultId() {
		return resultId;
	}
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
//	@Override
//	public String toString() {
//		return "Result [resultId=" + resultId + ", student=" + student + ", marks=" + marks + ", percentage="
//				+ percentage + "]";
//	}
	
	
}
