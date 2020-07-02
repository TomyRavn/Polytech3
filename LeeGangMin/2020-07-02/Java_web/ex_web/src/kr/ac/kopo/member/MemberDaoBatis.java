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
	
	private MemberDaoBatis() {}
	private static MemberDao memberDao = new MemberDaoBatis();
	public static MemberDao getInstance() {
		return memberDao;
	}
	
//	{
//		try {
//			//지정한 위치의 마이바티스 설정파일을 읽어서 SqlSessionFactory(Mybatis본체;jdbc기능을 편하게 해주는 역할)를 생성 
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
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션 열기
			//실행한 SQL문 종류와 같은 이름의 메서드를 사용하여 SQL문 실행
			//첫번째 인자로, 실행한 SQL문의 (namespace 포함 ; 소속 집합)id를 지정
			//결과로 여러개가 나온다면 selectList 메서드를 사용
			//두번째 인자는, 실행할 때 어떤 값을 주어야할 떄 해당하는 값
			list = session.selectList("kr.ac.kopo.member.MemberDao.selectMemberList");
		}
		return list;
	}
	
	@Override
	public MemberVo selectMember(String memId) {
		MemberVo vo = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			//SQL문 실행 시 필요한 값(파라미터)이 있는 경우, 두번째 인자로 전달
			vo = session.selectOne("kr.ac.kopo.member.MemberDao.selectMember", memId);
		}
		return vo;
	}

	@Override
	public int insertMember(MemberVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			num = session.insert("kr.ac.kopo.member.MemberDao.insertMember", vo);
			session.commit();
		}		
		return num;
	}

	@Override
	public void updateMember(MemberVo vo) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.update("kr.ac.kopo.member.MemberDao.updateMember", vo);
			session.commit();
		}
	}
	
	@Override
	public void deleteMember(String memId) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.delete("kr.ac.kopo.member.MemberDao.deleteMember", memId);
			session.commit();
		}
	}


//	@Override
//	public MemberVo selectLoginMember(String memId, String memPass) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public MemberVo selectLoginMember(MemberVo memberVo) {
		MemberVo vo = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			vo = session.selectOne("kr.ac.kopo.member.MemberDao.selectLoginMember", memberVo);
		}
		return vo;
	}


}
