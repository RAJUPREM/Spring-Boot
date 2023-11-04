package com.example.SpringBootBegining5.Entity;

public class ResultDto {
	
	public ResultDto() {
		super();
	}

	public ResultDto(int resultId) {
		super();
		this.resultId = resultId;
	}

	private int resultId;

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	@Override
	public String toString() {
		return "ResultDto [resultId=" + resultId + "]";
	}

}
