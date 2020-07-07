package kr.ac.kopo.student;

import java.util.ArrayList;
import java.util.List;

public interface StudentDao {

	List<StudentVo> selectStudentList();
	
	StudentVo selectStudent(String stuNo);

	int delStudent(String stuNo);

	int insertStudent(StudentVo vo);

	int updateStudentVo(StudentVo vo);

}