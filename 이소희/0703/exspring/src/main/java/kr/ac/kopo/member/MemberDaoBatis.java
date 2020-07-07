package kr.ac.kopo.member;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.comm.MyBatisUtils;

//이 객체를 DAO역할을 하는 객체로서 "memberDao"라는 이름으로 스프링에 등록
@Repository("memberDao")
public class MemberDaoBatis implements MemberDao {
	@Resource(name = "sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public List<MemberVo> selectMemberList() {
		List<MemberVo> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {// SQL문 실행을 위한 세션열
			// 실행할 SQL문 종류와 같은 이름의 메서드를 사용하여 SQL문 실행
			// 첫 번째 인자로, 실행할 SQL문의 (namespace 포함)id를 지정
			list = session.selectList("kr.ac.kopo.member.MemberDao.selectMemberList");
		}
		return list;
	}

	@Override
	public MemberVo selectMember(String MemId) {
		MemberVo vo = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {// SQL문 실행을 위한 세션열
			vo = session.selectOne("kr.ac.kopo.member.MemberDao.selectMember", MemId);
		}
		return vo;
	}

	@Override
	public int insertMember(MemberVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {// SQL문 실행을 위한 세션열기
			num = session.insert("kr.ac.kopo.member.MemberDao.insertMember", vo);
			session.commit();
		}
		return num;
	}

	@Override
	public int updateMember(MemberVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {// SQL문 실행을 위한 세션열
			num = session.update("kr.ac.kopo.member.MemberDao.updateMember", vo);
			session.commit();
		}
		return num;
	}

	@Override
	public int deleteMember(String memId) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {// SQL문 실행을 위한 세션열
			num = session.delete("kr.ac.kopo.member.MemberDao.deleteMember", memId);
			session.commit();
		}
		return num;
	}

	@Override
	public MemberVo selectLoginMember(MemberVo memberVo) {
		MemberVo vo = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {// SQL문 실행을 위한 세션열
			vo = session.selectOne("kr.ac.kopo.member.MemberDao.selectLoginMember", memberVo);
		}
		return vo;
	}

}
