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
import com.example.SpringBootBegining5.Entity.SchoolClass;
import com.example.SpringBootBegining5.Entity.SchoolClassDto;
import com.example.SpringBootBegining5.Entity.SchoolSubject;
import com.example.SpringBootBegining5.Entity.Student;
import com.example.SpringBootBegining5.Entity.StudentDto;
import com.example.SpringBootBegining5.Entity.Teacher;
import com.example.SpringBootBegining5.Entity.TeacherDto;
//import com.example.SpringBootBegining5.Repsitory.AddressRepository;
import com.example.SpringBootBegining5.Repsitory.MarksRepository;
import com.example.SpringBootBegining5.Repsitory.ResultRepository;
import com.example.SpringBootBegining5.Repsitory.SchoolClassRepository;
import com.example.SpringBootBegining5.Repsitory.StudentRepository;
import com.example.SpringBootBegining5.Repsitory.TeacherRepository;
import com.example.SpringBootBegining5.Service.ServiceReq;
import com.example.SpringBootBegining5.constraints.SubjectNameAccordingToClass;


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
	
	@Autowired
	private SchoolClassRepository schoolClassRepository;
	
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
	public void saveTeacher(TeacherDto teacherDto) {
		Teacher teacher=new Teacher();
		teacher.setTeacherId(teacherDto.getTeacherId());
		teacher.setAddress(teacherDto.getAddress());
		teacher.setTeacherMobile(teacherDto.getTeacherMobile());
		teacher.setTeacherName(teacherDto.getTeacherName());
		teacher.setTeacherSubjectName(teacherDto.getTeacherSubjectName());
		teacher.setSchoolClass(null);
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
//		System.out.println(result.getPercentage());
//		resultRepository.save(result);
		
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

	@Override
	public Teacher getTeacherById(int teacherId) {
		Optional<Teacher> tempTeacher=teacherRepository.findById(teacherId);
		Teacher teacher=tempTeacher.get();
		return teacher;
	}

	@Override
	public List<Teacher> getTeachers() {
		List<Teacher> lteacher=teacherRepository.findAll();
		return lteacher;
	}
	
	public static SchoolSubject getSubject(String sub[])
	{
		SchoolSubject schoolSubjectTemp=new SchoolSubject();
		
		for(String tempSub:sub)
		{
			if(tempSub.equals("maths"))
			{
				schoolSubjectTemp.setMaths(true);
			}
			else if(tempSub.equals("hindi"))
			{
				schoolSubjectTemp.setHindi(true);
			}
			else if(tempSub.equals("english"))
			{
				schoolSubjectTemp.setEnglish(true);
			}
			else if(tempSub.equals("science"))
			{
				schoolSubjectTemp.setScience(true);
			}
			else if(tempSub.equals("sst"))
			{
				schoolSubjectTemp.setSst(true);
			}
			else if(tempSub.equals("computer"))
			{
				schoolSubjectTemp.setComputer(true);
			}
		}
		
		
		return schoolSubjectTemp;
	}

	@Override
	public void createSchoolClass(SchoolClassDto schoolClassDto) {
		SchoolClass schoolClass=new SchoolClass();
		
		schoolClass.setSchoolClassSection(schoolClassDto.getSchoolClassSection());
		schoolClass.setSchoolClassStandard(schoolClassDto.getSchoolClassStandard());
		
		schoolClass.setSchoolClassId();
		
		SchoolSubject schoolSubject=new SchoolSubject();
		
		if(schoolClassDto.getSchoolClassStandard().equals("one"))
		{
			String sub[]=SubjectNameAccordingToClass.one;
			schoolSubject=getSubject(sub);
		}
		else if(schoolClassDto.getSchoolClassStandard().equals("two"))
		{
			String sub[]=SubjectNameAccordingToClass.two;
			schoolSubject=getSubject(sub);
		}
		else if(schoolClassDto.getSchoolClassStandard().equals("three"))
		{
			String sub[]=SubjectNameAccordingToClass.three;
			schoolSubject=getSubject(sub);
		}
		else if(schoolClassDto.getSchoolClassStandard().equals("four"))
		{
			String sub[]=SubjectNameAccordingToClass.four;
			schoolSubject=getSubject(sub);
		}
		else if(schoolClassDto.getSchoolClassStandard().equals("five"))
		{
			String sub[]=SubjectNameAccordingToClass.five;
			schoolSubject=getSubject(sub);
		}
		else if(schoolClassDto.getSchoolClassStandard().equals("six"))
		{
			String sub[]=SubjectNameAccordingToClass.six;
			schoolSubject=getSubject(sub);
		}
		else if(schoolClassDto.getSchoolClassStandard().equals("seven"))
		{
			String sub[]=SubjectNameAccordingToClass.seven;
			schoolSubject=getSubject(sub);
		}
		else if(schoolClassDto.getSchoolClassStandard().equals("eight"))
		{
			String sub[]=SubjectNameAccordingToClass.eight;
			schoolSubject=getSubject(sub);
		}
		else if(schoolClassDto.getSchoolClassStandard().equals("nine"))
		{
			String sub[]=SubjectNameAccordingToClass.nine;
			schoolSubject=getSubject(sub);
		}
		else if(schoolClassDto.getSchoolClassStandard().equals("ten"))
		{
			String sub[]=SubjectNameAccordingToClass.ten;
			schoolSubject=getSubject(sub);
		}
		else if(schoolClassDto.getSchoolClassStandard().equals("eleven"))
		{
			String sub[]=SubjectNameAccordingToClass.eleven;
			schoolSubject=getSubject(sub);
		}
		else if(schoolClassDto.getSchoolClassStandard().equals("twelve"))
		{
			String sub[]=SubjectNameAccordingToClass.twelve;
			schoolSubject=getSubject(sub);
		}
		
		schoolClass.setSchoolSubject(schoolSubject);
		
		//List<Student> lstudent=new ArrayList<Student>();
		
		int [] lstuId=schoolClassDto.getStudentId();
		
		for(int i=0;i<schoolClassDto.getStudentId().length;i++)
		{
			Optional<Student> tempStudent=studentRepository.findById(lstuId[i]);
			//lstudent.add(tempStudent.get());
			Student student=tempStudent.get();
			student.setSchoolClass(schoolClass);
			studentRepository.save(student);
		}
		
		//schoolClass.setStudents(lstudent);
		
		//List<Teacher> lteacher=new ArrayList<Teacher>();
		
		int [] lteaId=schoolClassDto.getTeacherId();
		
		for(int i=0;i<schoolClassDto.getTeacherId().length;i++)
		{
			Optional<Teacher> tempTeacher=teacherRepository.findById(lteaId[i]);
			Teacher teacher=tempTeacher.get();
			teacher.setSchoolClass(schoolClass);
			teacherRepository.save(teacher);
			//lteacher.add(tempTeacher.get());
		}
		
		//schoolClass.setTeachers(lteacher);
		
		//schoolClassRepository.save(schoolClass);
		
	}

	public SchoolClassRepository getSchoolClassRepository() {
		return schoolClassRepository;
	}

	public void setSchoolClassRepository(SchoolClassRepository schoolClassRepository) {
		this.schoolClassRepository = schoolClassRepository;
	}

	@Override
	public List<SchoolClass> getSchoolClasses() {
		List<SchoolClass> lschoolClass=schoolClassRepository.findAll();
		return lschoolClass;
	}

	@Override
	public List<Student> getAllStudentOfSchoolClasses(String schoolClassId) {
			List<Student> lstudent=studentRepository.findAll();
			
			List<Student> lstud=new ArrayList<Student>();			
			for(Student student:lstudent)
			{
				if(student.getSchoolClass()!=null)
				{
					if(student.getSchoolClass().getSchoolClassId().equals(schoolClassId))
					{
						lstud.add(student);
					}
				}
			}
			
			
		return lstud;
	}

	@Override
	public List<Teacher> getAllTeacherOfSchoolClasses(String schoolClassId) {
		List<Teacher> lteacher=teacherRepository.findAll();
		
		List<Teacher> lteach=new ArrayList<Teacher>();
		
		for(Teacher teacher:lteacher)
		{
			if(teacher.getSchoolClass()!=null)
			{
				if(teacher.getSchoolClass().getSchoolClassId().equals(schoolClassId))
				{
					lteach.add(teacher);			
				}
			}
		}
		
		return lteach;
	}

	

	

	

	


}
