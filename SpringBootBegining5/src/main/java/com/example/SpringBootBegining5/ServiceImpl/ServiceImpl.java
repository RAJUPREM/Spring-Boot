package com.example.SpringBootBegining5.ServiceImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootBegining5.Entity.Marks;
import com.example.SpringBootBegining5.Entity.Result;
import com.example.SpringBootBegining5.Entity.ResultDto;
import com.example.SpringBootBegining5.Entity.Student;
import com.example.SpringBootBegining5.Entity.StudentDto;
import com.example.SpringBootBegining5.Entity.Teacher;
//import com.example.SpringBootBegining5.Repsitory.AddressRepository;
import com.example.SpringBootBegining5.Repsitory.MarksRepository;
import com.example.SpringBootBegining5.Repsitory.ResultRepository;
import com.example.SpringBootBegining5.Repsitory.StudentRepository;
import com.example.SpringBootBegining5.Repsitory.TeacherRepository;
import com.example.SpringBootBegining5.Service.ServiceReq;


@Service
public class ServiceImpl implements ServiceReq{
	
	public ServiceImpl() {
		super();
		
	}

	public ServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private MarksRepository marksRepository;
	
	@Autowired
	private ResultRepository resultRepository;
	
	@Override
	public Student getStudentById(int studentId) {
		Optional<Student> stu=studentRepository.findById(studentId);
		Student newStudent=stu.get();
		return newStudent;
	}

	@Override
	public List<Student> getStudents() {
		List<Student> lstudent=studentRepository.findAll();
		return lstudent;
	}

	@Override
	public Student getStudentByResultId(int resultId) {
		Optional<Result> tempRes=resultRepository.findById(resultId);
		Result result=tempRes.get();
		Student student=result.getStudent();
		return student;
	}

	@Override
	public void saveStudent(StudentDto studentDto) {
		Student student=new Student();
		student.setAddress(studentDto.getAddress());
		student.setResult(null);
		student.setSchoolClass(null);
		student.setStudentId(studentDto.getStudentId());
		student.setStudentMobile(studentDto.getStudentMobile());
		student.setStudentName(studentDto.getStudentName());
		student.setStudentRoll(studentDto.getStudentRoll());
		if(student.getResult()!=null)
		{
		student.getResult().setPercentage(student.getResult().getMarks());
		}
		studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(int studentId) {

		studentRepository.deleteById(studentId);
	}

	@Override
	public void updateStudentById(Student student) {
		studentRepository.save(student);
		
	}

	public StudentRepository getStudentRepository() {
		return studentRepository;
	}

	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	
	@Override
	public void saveTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
	}
	

	@Override
	public Result getResultByStudentId(int studentId) {
		Optional<Student> stu=studentRepository.findById(studentId);
		Student newStudent=stu.get();	
		Result result=newStudent.getResult();
		return result;
	}

	@Override
	public void saveResult(ResultDto resultDto,int studentId,int marksId) {
		Optional<Marks> tempMarks=marksRepository.findById(marksId);
		Optional<Student> tempStudent=studentRepository.findById(studentId);
		
		Result result=new Result();
		result.setResultId(resultDto.getResultId());
		System.out.println(tempMarks.get());
		System.out.println(tempStudent.get());
		
		result.setPercentage(tempMarks.get());
		result.setMarks(tempMarks.get());
		result.setStudent(tempStudent.get());
		Student student=tempStudent.get();
		student.setResult(result);
		studentRepository.save(student);
		System.out.println(result.getPercentage());
		resultRepository.save(result);
		
	}
	
	@Override
	public void saveMarks(Marks marks) {
		marksRepository.save(marks);
	}

	@Override
	public Marks getMarksById(int marksId) {
		Optional<Marks> tempOpMark=marksRepository.findById(marksId);
		Marks tempMarks=tempOpMark.get();
		return tempMarks;
	}
	
	@Override
	public Result getResultById(int resultId) {
		Optional<Result> tempOpResult=resultRepository.findById(resultId);
		Result tempResult=tempOpResult.get();
		return tempResult;
	}

	public ResultRepository getResultRepository() {
		return resultRepository;
	}

	public void setResultRepository(ResultRepository resultRepository) {
		this.resultRepository = resultRepository;
	}

//	@Override
//	public Map<Integer,String>  getClassResult(String className) {
//		 
//			List<Result> lresult=new ArrayList<Result>();
//			lresult=resultRepository.findAll();
//			//List<Student> lstu=studentRepository.findAll();
//	
//			//Map<Integer,String> lstu=new LinkedHashMap<Integer,String>();
//			
//			Map<Integer,String> lhm=new LinkedHashMap<Integer,String>();
//			
//			for(Result tempResult:lresult)
//			{
//				if(tempResult.getPercentage()>32 && tempResult.getStudent().getClassName().equals(className))
//				{
//					//lstu.put(tempResult.getStudent().getStudentId(), tempResult.getStudent().getStudentName());
////					System.out.println(tempResult.getStudent());
////					System.out.println(tempResult.getStudent().getClass());
//					lhm.put(tempResult.getStudent().getStudentId(), "Pass");
//				}
//				else if(tempResult.getPercentage()<32 && tempResult.getStudent().getClassName().equals(className))
//				{
//					//lstu.put(tempResult.getStudent().getStudentId(), tempResult.getStudent().getStudentName());
//					lhm.put(tempResult.getStudent().getStudentId(), "Fail");
//				}
//				
//			}
//			
//			return lhm;
//		
//		
//	}

	@Override
	public Map<Integer, String> getClassResultOfAllStudent() {
		
		List<Result> lresult=new ArrayList<Result>();
		lresult=resultRepository.findAll();
		
		//Map<Integer,String> lstu=new LinkedHashMap<Integer,String>();
		
		Map<Integer,String> lhm=new LinkedHashMap<Integer,String>();
		
		for(Result tempResult:lresult)
		{
			if(tempResult.getPercentage()>32)
			{
				//lstu.put(tempResult.getStudent().getStudentId(), tempResult.getStudent().getStudentName());
				lhm.put(tempResult.getStudent().getStudentId(), "Pass");
			}
			else if(tempResult.getPercentage()<32)
			{
				//lstu.put(tempResult.getStudent().getStudentId(), tempResult.getStudent().getStudentName());
				lhm.put(tempResult.getStudent().getStudentId(), "Fail");
			}
			
		}
		
		return lhm;
		
		
	}

//	public AddressRepository getAddressRepository() {
//		return addressRepository;
//	}
//
//	public void setAddressRepository(AddressRepository addressRepository) {
//		this.addressRepository = addressRepository;
//	}

	public MarksRepository getMarksRepository() {
		return marksRepository;
	}

	public void setMarksRepository(MarksRepository marksRepository) {
		this.marksRepository = marksRepository;
	}

	public TeacherRepository getTeacherRepository() {
		return teacherRepository;
	}

	public void setTeacherRepository(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	@Override
	public Map<Integer, String> getClassResult(String className) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	

	


}
