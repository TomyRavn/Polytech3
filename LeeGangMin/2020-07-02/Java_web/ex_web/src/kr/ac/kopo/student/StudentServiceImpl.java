package kr.ac.kopo.student;

import java.util.List;

public class StudentServiceImpl implements StudentService{
	
	private StudentServiceImpl() {}
	private static StudentService studentService = new StudentServiceImpl();
	public static StudentService getInstance() {
		return studentService;
	}
	
	private StudentDao studentDao = StudentDaoBatis.getInstance();
	
	@Override
	public List<StudentVo> selectStudentList() {
		return studentDao.selectStudentList();
	}

	@Override
	public int insertStudent(StudentVo vo) {
		return studentDao.insertStudent(vo);
	}

	@Override
	public void deleteStudent(String stuNo) {
		studentDao.deleteStudent(stuNo);
	}

	@Override
	public StudentVo selectStudent(String stuNo) {
		return studentDao.selectStudent(stuNo);
	}

	@Override
	public void updateStudent(StudentVo vo) {
		studentDao.updateStudent(vo);
	}

}
