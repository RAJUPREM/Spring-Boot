package com.example.SpringBootBegining5.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Marks {
	
	
	public Marks(int marksId, int maths, int science, int sst, int hindi, int english) {
		super();
		this.marksId = marksId;
		this.maths = maths;
		this.science = science;
		this.sst = sst;
		this.hindi = hindi;
		this.english = english;
	}
	public Marks() {
		super();
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int marksId;
	private int maths;
	private int science;
	private int sst;
	private int hindi;
	private int english;
	public int getMaths() {
		return maths;
	}
	public void setMaths(int maths) {
		this.maths = maths;
	}
	public int getScience() {
		return science;
	}
	public void setScience(int science) {
		this.science = science;
	}
	public int getSst() {
		return sst;
	}
	public void setSst(int sst) {
		this.sst = sst;
	}
	public int getHindi() {
		return hindi;
	}
	public void setHindi(int hindi) {
		this.hindi = hindi;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	
	public int getmarksId() {
		return marksId;
	}
	public void setmarksId(int marksId) {
		this.marksId = marksId;
	}
	@Override
	public String toString() {
		return "Marks [marksId=" + marksId + ", maths=" + maths + ", science=" + science + ", sst=" + sst + ", hindi="
				+ hindi + ", english=" + english + "]";
	}

}
