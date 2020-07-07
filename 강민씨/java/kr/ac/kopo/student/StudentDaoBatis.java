package kr.ac.kopo.student;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.comm.MyBatisUtils;

@Repository("studentDao")
public class StudentDaoBatis implements StudentDao {
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public List<StudentVo> selectStudentList() {
		List<StudentVo> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			list = session.selectList("kr.ac.kopo.student.StudentDao.selectStudentList");
		}
		return list;	
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
	public int insertStudent(StudentVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {// SQL문 실행을 위한 세션열기
			// SQL문 실행시 필요한 값(파라미터)이 있는 경우, 두번째 인자로 전달
			num = session.insert("kr.ac.kopo.student.StudentDao.insertStudent", vo);
			session.commit();
		}
		return num;
	}

	@Override
	public int updateStudentVo(StudentVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {// SQL문 실행을 위한 세션열기
			// SQL문 실행시 필요한 값(파라미터)이 있는 경우, 두번째 인자로 전달
			num = session.update("kr.ac.kopo.student.StudentDao.updateStudentVo", vo);
			session.commit();
		}
		return num;
	}
	
	@Override
	public int deleteStudent(String stuNo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {// SQL문 실행을 위한 세션열기
			// SQL문 실행시 필요한 값(파라미터)이 있는 경우, 두번째 인자로 전달
			num = session.delete("kr.ac.kopo.student.StudentDao.deleteStudent", stuNo);
			session.commit();
		}
		return num;
	}

}
