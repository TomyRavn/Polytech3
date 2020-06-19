package kr.ac.kopo.member;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.ac.kopo.comm.MyBatisUtils;

public class MemberDaoBatis implements MemberDao{
	
	private SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();

//	{
//		try {
//			//������ ��ġ�� ���̹�Ƽ�� ���������� �о SqlSessionFactory�� ����
//			String resource = "batis/mybatis-config.xml";
//			InputStream inputStream = Resources.getResourceAsStream(resource);
//			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public List<MemberVo> selectMemberList() {
		List<MemberVo> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL�� ������ ���� ���ǿ���
			//������ SQL�� ������ ���� �̸��� �޼��带 ����Ͽ� SQL�� ����
			//ù���� ���ڷ�, ������ SQL���� (namespace ����) id�� ����
			list = session.selectList("kr.ac.kopo.member.MemberDao.selectMemberList");
		}
		return list;
	}

	@Override
	public MemberVo selectMember(String memId) {
		MemberVo vo = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL�� ������ ���� ���ǿ���
			//SQL�� ����� �ʿ��� ��(�Ķ����)�� �ִ� ���, �ι�° ���ڷ� ����
			vo = session.selectOne("kr.ac.kopo.member.MemberDao.selectMember", memId);
		}
		return vo;
	}

	@Override
	public int insertMember(MemberVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL�� ������ ���� ���ǿ���
			num = session.insert("kr.ac.kopo.member.MemberDao.insertMember", vo);
			session.commit();
			//commit�� ���ش�.
		}
		return num;
	}

	@Override
	public int updateMember(MemberVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL�� ������ ���� ���ǿ���
			num = session.update("kr.ac.kopo.member.MemberDao.updateMember", vo);
			session.commit();
		}
		return num;
	}

	@Override
	public int deleteMember(String memId) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL�� ������ ���� ���ǿ���
			num = session.delete("kr.ac.kopo.member.MemberDao.deleteMember", memId);
			session.commit();
		}
		return num;
	}

	@Override
	public MemberVo selectLoginMember(MemberVo memberVo) {
		MemberVo vo = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL�� ������ ���� ���ǿ���
			vo = session.selectOne("kr.ac.kopo.member.MemberDao.selectLoginMember", memberVo);
		}
		return vo;
	}

}
