package kr.ac.kopo.student;

import java.util.ArrayList;
import java.util.List;

public interface StudentDao {

	ArrayList<StudentVo> selectStudentList();

	int deleteStudent(String stuNo);

	int insertStudent(StudentVo vo);

	StudentVo selectStudent(String StuNo);

	int updateStudentVo(StudentVo vo);

}