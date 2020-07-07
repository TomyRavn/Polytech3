package kr.ac.kopo.student;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Resource(name="studentDao")
	private StudentDao studentDao;
	
	@Override
	public List<StudentVo> selectStudentList() {		
		return studentDao.selectStudentList();
	}

	@Override
	public StudentVo selectStudent(String StuNo) {
		return studentDao.selectStudent(StuNo);
	}

	@Override
	public int delStudent(String stuNo) {
		return studentDao.delStudent(stuNo);
	}

	@Override
	public int insertStudent(StudentVo vo) {
		return studentDao.insertStudent(vo);
	}

	@Override
	public int updateStudentVo(StudentVo vo) {
		return studentDao.updateStudentVo(vo);
		
	}
	

}
