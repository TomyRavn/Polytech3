package kr.ac.kopo.member;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

//이 객체를 DAO역할을 하는 객체로서 "memberDao"라는 이름으로 스프링에 등록
//@Repository("memberDao")
public class MemberDaoBatis implements MemberDao {
//	@Resource(name="sqlSessionFactory")
//	private SqlSessionFactory sqlSessionFactory;	
	@Resource(name="sqlSession")
	private SqlSession session;


	@Override
	public List<MemberVo> selectMemberList() {
		return session.selectList("kr.ac.kopo.member.MemberDao.selectMemberList");			
		}
	

	@Override
	public MemberVo selectMember(String memId) {
			return session.selectOne("kr.ac.kopo.member.MemberDao.selectMember", memId);		
	}

	@Override
	public int insertMember(MemberVo vo) {
			return session.insert("kr.ac.kopo.member.MemberDao.insertMember", vo);

	}

	@Override
	public int updateMember(MemberVo vo) {
			return session.update("kr.ac.kopo.member.MemberDao.updateMember", vo);
	
	}

	@Override
	public int delMember(String memId) {	
			return session.delete("kr.ac.kopo.member.MemberDao.delMember", memId);
	
	}

	@Override
	public MemberVo selectLoginMember(MemberVo memberVo) {	
			return session.selectOne("kr.ac.kopo.member.MemberDao.selectLoginMember", memberVo);
		}
	
	}

