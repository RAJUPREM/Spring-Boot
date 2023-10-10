package com.example.SpringBootBegining5.Service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.example.SpringBootBegining5.Entity.Marks;
import com.example.SpringBootBegining5.Entity.Result;
import com.example.SpringBootBegining5.Entity.Student;
import com.example.SpringBootBegining5.Entity.Teacher;

public interface ServiceReq {
	
	public Student getStudentById(int studentId);
	
	public List<Student> getStudents();
	
	@Transactional
	public void saveStudent(Student student);
	
	public void deleteStudentById(int studentId);
	
	@Transactional
	public void updateStudentById(Student student);
	
	public Map<Integer,String> getClassResult(String className);
	
	public Result getResultByStudentId(int studentId);
	
	public void saveResult(Result result,int studentId,int marksId);
	
	public Map<Integer,String> getClassResultOfAllStudent();
	
	public Marks getMarksById(int marksId);
	
	public void saveMarks(Marks marks);
	
	public Result getResultById(int resultId);
	
	
	public Student getStudentByResultId(int resultId);
	
	public void saveTeacher(Teacher teacher);
	
	
	

}
