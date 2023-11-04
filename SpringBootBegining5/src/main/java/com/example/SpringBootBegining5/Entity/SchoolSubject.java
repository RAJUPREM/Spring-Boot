package com.example.SpringBootBegining5.Entity;

import javax.persistence.Embeddable;

@Embeddable
public class SchoolSubject {
	
	public SchoolSubject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SchoolSubject(boolean maths, boolean science, boolean sst, boolean hindi, boolean english,
			boolean computer) {
		super();
		this.maths = maths;
		this.science = science;
		this.sst = sst;
		this.hindi = hindi;
		this.english = english;
		this.computer = computer;
	}
	private boolean maths;
	private boolean science;
	private boolean sst;
	private boolean hindi;
	private boolean english;
	private boolean computer;
	public boolean isMaths() {
		return maths;
	}
	public void setMaths(boolean maths) {
		this.maths = maths;
	}
	public boolean isScience() {
		return science;
	}
	public void setScience(boolean science) {
		this.science = science;
	}
	public boolean isSst() {
		return sst;
	}
	public void setSst(boolean sst) {
		this.sst = sst;
	}
	public boolean isHindi() {
		return hindi;
	}
	public void setHindi(boolean hindi) {
		this.hindi = hindi;
	}
	public boolean isEnglish() {
		return english;
	}
	public void setEnglish(boolean english) {
		this.english = english;
	}
	public boolean isComputer() {
		return computer;
	}
	public void setComputer(boolean computer) {
		this.computer = computer;
	}
	@Override
	public String toString() {
		return "SchoolSubject [maths=" + maths + ", science=" + science + ", sst=" + sst + ", hindi=" + hindi
				+ ", english=" + english + ", computer=" + computer + "]";
	}

}
