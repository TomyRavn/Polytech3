package kr.ac.kopo.student;

import java.util.List;

public interface StudentService {

	List<StudentVo> selectStudentList();

	int insertStudent(StudentVo vo);

	void deleteStudent(String stuNo);

	StudentVo selectStudent(String stuNo);

	void updateStudent(StudentVo vo);

}