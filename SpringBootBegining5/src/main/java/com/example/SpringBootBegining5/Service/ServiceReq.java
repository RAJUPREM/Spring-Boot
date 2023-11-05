package com.example.SpringBootBegining5.Service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.example.SpringBootBegining5.Entity.Marks;
import com.example.SpringBootBegining5.Entity.Result;
import com.example.SpringBootBegining5.Entity.ResultDto;
import com.example.SpringBootBegining5.Entity.SchoolClass;
import com.example.SpringBootBegining5.Entity.SchoolClassDto;
import com.example.SpringBootBegining5.Entity.Student;
import com.example.SpringBootBegining5.Entity.StudentDto;
import com.example.SpringBootBegining5.Entity.Teacher;
import com.example.SpringBootBegining5.Entity.TeacherDto;

public interface ServiceReq {
	
	public Student getStudentById(int studentId);
	
	public List<Student> getStudents();
	
	@Transactional
	public void saveStudent(StudentDto studentDto);
	
	public void deleteStudentById(int studentId);
	
	@Transactional
	public void updateStudentById(Student student);
	
	public Map<Integer,String> getClassResult(String className);
	
	public Result getResultByStudentId(int studentId);
	
	public void saveResult(ResultDto resultDto,int studentId,int marksId);
	
	public Map<Integer,String> getClassResultOfAllStudent();
	
	public Marks getMarksById(int marksId);
	
	public void saveMarks(Marks marks);
	
	public Result getResultById(int resultId);
	
	
	public Student getStudentByResultId(int resultId);
	
	public void saveTeacher(TeacherDto teacherDto);
	
	public Teacher getTeacherById(int teacherId);	
	
	public List<Teacher> getTeachers();
	
	public void createSchoolClass(SchoolClassDto schoolClassDto);
	
	public List<SchoolClass> getSchoolClasses();
	
	public List<Student> getAllStudentOfSchoolClasses(String schoolClassId);
	
	public List<Teacher> getAllTeacherOfSchoolClasses(String schoolClassId);
	

}
