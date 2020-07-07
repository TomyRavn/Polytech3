package kr.ac.kopo.student;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.ac.kopo.member.MemberVo;

public class StuudentDaoBatis implements StudentDao{
	SqlSessionFactory sqlSessionFactory;
	
	{
		try {
			String resource = "batis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<StudentVo> selectStudentList() {
		List<StudentVo> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			list = session.selectList("kr.ac.kopo.student.StudentDao.selectStudentList");
			}
		
		return list;
	}

	@Override
	public int deleteStudent(String stuNo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {// SQL문 실행을 위한 세션열
			num = session.delete("kr.ac.kopo.student.StudentDao.deleteStudent", stuNo);
			session.commit();
		}
		return num;
	}

	@Override
	public int insertStudent(StudentVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {// SQL문 실행을 위한 세션열
			num = session.insert("kr.ac.kopo.student.StudentDao.insertStudent", vo);
			session.commit();
		}
		return num;
	}

	@Override
	public StudentVo selectStudent(String StuNo) {
		StudentVo vo = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {// SQL문 실행을 위한 세션열
			vo = session.selectOne("kr.ac.kopo.student.StudentDao.selectStudent", StuNo);
		}
		return vo;
	}

	@Override
	public int updateStudentVo(StudentVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {// SQL문 실행을 위한 세션열
			num = session.update("kr.ac.kopo.student.StudentDao.updateStudent", vo);
			session.commit();
		}
		return num;
	}

}
