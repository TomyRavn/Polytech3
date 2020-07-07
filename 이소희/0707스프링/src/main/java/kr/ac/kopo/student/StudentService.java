package kr.ac.kopo.student;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {

	List<StudentVo> selectStudentList();
	
	StudentVo selectStudent(String StuNo);

	int delStudent(String stuNo);

	int insertStudent(StudentVo vo);

	int updateStudentVo(StudentVo vo);

}