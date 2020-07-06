package kr.ac.kopo.member;

import java.util.List;


public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao = MemberDaoBatis.getInstance();
		
//싱글톤(Singleton pattern) : 애플리케이션 전체에서 객체(인스턴스)를 "1개만" 만들어서(new) 여러곳에서 함께 사용 
	private MemberServiceImpl() {} //외부에서 인스턴스 생성 금지
	private static MemberService memberService = new MemberServiceImpl();
	public static MemberService getInstance() {
		return memberService;
	}

	@Override
	public List<MemberVo> selectMemberList() {		
//		List<MemberVo> list = memberDao.selectMemberList();
//		코드구현	
//		return list;		
		return memberDao.selectMemberList();
	}

	@Override
	public MemberVo selectMember(String memId) {
		return memberDao.selectMember(memId);
	}

	@Override
	public int insertMember(MemberVo vo) {	
		return memberDao.insertMember(vo);
	}

	@Override
	public int updateMember(MemberVo vo) {	
		return memberDao.updateMember(vo);
	}

	@Override
	public int delMember(String memId) {	
		return memberDao.delMember(memId);
	}

	@Override
	public MemberVo selectLoginMember(MemberVo memberVo) {		
		return memberDao.selectLoginMember(memberVo);
	}
	

}
