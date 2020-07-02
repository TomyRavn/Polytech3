package kr.ac.kopo.student;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.ac.kopo.comm.MyBatisUtils;

public class StudentDaoBatis implements StudentDao{

	private SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
	
	public StudentDaoBatis() {}
	private static StudentDao studentDao = new StudentDaoBatis();
	public static StudentDao getInstance() {
		return studentDao;
	}
	
	@Override
	public List<StudentVo> selectStudentList() {
		List<StudentVo> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			list = session.selectList("kr.ac.kopo.student.StudentDao.selectStudentList");
		}
		return list;
	}

	@Override
	public int insertStudent(StudentVo vo) {
		int num = 0;
		try(SqlSession session = sqlSessionFactory.openSession()){
			num = session.insert("kr.ac.kopo.student.StudentDao.insertStudent", vo);
			session.commit();
		}
		return num;
	}

	@Override
	public void deleteStudent(String stuNo) {
		try(SqlSession session = sqlSessionFactory.openSession()){
			session.delete("kr.ac.kopo.student.StudentDao.deleteStudent", stuNo);
			session.commit();
		}
	}

	@Override
	public StudentVo selectStudent(String stuNo) {
		StudentVo vo = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			vo = session.selectOne("kr.ac.kopo.student.StudentDao.selectStudent", stuNo);
		}
		return vo;
	}

	@Override
	public void updateStudent(StudentVo vo) {
		try(SqlSession session = sqlSessionFactory.openSession()){
			session.update("kr.ac.kopo.student.StudentDao.updateStudent", vo);
			session.commit();
		}
	}

}
