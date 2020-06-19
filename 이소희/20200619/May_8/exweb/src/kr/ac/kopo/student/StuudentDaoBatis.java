package kr.ac.kopo.student;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			  Blog blog = session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
			}
		
		return list;
	}

	@Override
	public int deleteStudent(String stuNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertStudent(StudentVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StudentVo selectStudent(String StuNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStudentVo(StudentVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
