package com.example.SpringBootBegining5.Controller;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootBegining5.Entity.Marks;
import com.example.SpringBootBegining5.Entity.Result;
import com.example.SpringBootBegining5.Entity.Student;
import com.example.SpringBootBegining5.Repsitory.StudentRepository;
import com.example.SpringBootBegining5.ServiceImpl.ServiceImpl;

@RestController
@RequestMapping("/school")
public class Controller {
	
	@Autowired
	ServiceImpl serviceImpl=null;
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping(value="/welcome")
	public String welcome()
	{
		return "Welcome";
	}
	
	@GetMapping(value="/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int studentId)
	{
		Student stu=serviceImpl.getStudentById(studentId);
		return new ResponseEntity<>(stu, HttpStatus.OK);
	}
	
	@GetMapping(value="/students")
	public ResponseEntity<List<Student>> getAllStudent()
	{
		List<Student> lstudent=serviceImpl.getStudents();
		return new ResponseEntity<>(lstudent,HttpStatus.OK);
	}
	
	@GetMapping(value="/student/result/{id}")
	public ResponseEntity<Result> getResultByStudentId(@PathVariable("id") int resultId)
	{
		Result res=serviceImpl.getResultByStudentId(resultId);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping("/result/students/{id}")
	public ResponseEntity<Student> getStudentByResultId(@PathVariable("id") int resultId)
	{
		Student student=serviceImpl.getStudentByResultId(resultId);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@GetMapping(value="/result/{id}")
	public ResponseEntity<Result> getResult(@PathVariable("id") int resultId)
	{
		Result res=serviceImpl.getResultById(resultId);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping(value="/marks/{id}")
	public ResponseEntity<Marks> getMarks(@PathVariable("id") int marksId)
	{
		Marks mar=serviceImpl.getMarksById(marksId);
		return new ResponseEntity<>(mar, HttpStatus.OK);
	}
	
	@PostMapping(value="/studentEntity")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) 
	{
		System.out.println(student);
		serviceImpl.saveStudent(student);
		return new ResponseEntity<String>("Student Inserted", HttpStatus.OK);
	}
	
	@PostMapping(value="/students/{studentId}/marks/{marksId}/resultEntity")
	public ResponseEntity<String> saveResult(@RequestBody Result result,@PathVariable("studentId") int studentId,@PathVariable("marksId") int marksId) 
	{
		//System.out.println(result.getMarks().toString());
		System.out.println(result.getPercentage());
		serviceImpl.saveResult(result,studentId,marksId);
		return new ResponseEntity<String>("Result Inserted", HttpStatus.OK);
	}
	
	@PostMapping(value="/marksEntity")
	public ResponseEntity<String> saveMarks(@RequestBody Marks marks) 
	{
		System.out.println(marks);
		serviceImpl.saveMarks(marks);
		return new ResponseEntity<String>("Marks Inserted", HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/students/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable("id") int studentId)
	{
		serviceImpl.deleteStudentById(studentId);
		return new ResponseEntity<String>("Student deleted", HttpStatus.OK);
	}
	
	@PutMapping(value="/students/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student student)
	{
		serviceImpl.updateStudentById(student);
		return new ResponseEntity<String>("Student details Updated",HttpStatus.OK);
	}
	
	
	@GetMapping(value="/classResult/{className}")
	public ResponseEntity<Map<String,String>> getClassResult(@PathVariable("className") String className)
	{
		Map<Integer,String> classResult=serviceImpl.getClassResult(className);
		Map<String,String> lhmstu=new LinkedHashMap<String,String>();
		
		for(Map.Entry<Integer,String> temp:classResult.entrySet())
		{
			Optional<Student> lstu=studentRepository.findById(temp.getKey());
			
			String t="Id : "+lstu.get().getStudentId()+" "+", Name : "+lstu.get().getStudentName()+" "+", Roll : "+lstu.get().getStudentRoll();
			lhmstu.put(t, temp.getValue());
		}
		return new ResponseEntity<Map<String,String>>(lhmstu,HttpStatus.OK);
	}
	
	
	
	@GetMapping(value="/classResult")
	public ResponseEntity<Map<String,String>> getClassResultOfAllStudent()
	{
		Map<Integer,String> classResult=serviceImpl.getClassResultOfAllStudent();
		Map<String,String> lhmstu=new LinkedHashMap<String,String>();
		
		for(Map.Entry<Integer,String> temp:classResult.entrySet())
		{
			Optional<Student> lstu=studentRepository.findById(temp.getKey());
			
			String t="Id : "+lstu.get().getStudentId()+" "+", Name : "+lstu.get().getStudentName()+" "+", Roll : "+lstu.get().getStudentRoll();
			lhmstu.put(t, temp.getValue());
		}
		return new ResponseEntity<Map<String,String>>(lhmstu,HttpStatus.OK);
	}

	
}
