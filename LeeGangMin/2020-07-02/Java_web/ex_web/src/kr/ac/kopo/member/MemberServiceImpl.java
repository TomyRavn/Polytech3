package kr.ac.kopo.member;

import java.util.List;

//Impl -> Implement : 구현체
//Service : 핵심 비지니스 로직이 작성되는 부분
public class MemberServiceImpl implements MemberService{

	private MemberServiceImpl() {}											//외부에서 인스턴스 생성 금지
	private static MemberService memberService = new MemberServiceImpl();	//static을 붙여 메모리가 로드될 때 객체 생성
	public static MemberService getInstance() {
		return memberService;
	}

	private MemberDao memberDao = MemberDaoBatis.getInstance();
	
	@Override
	public List<MemberVo> selectMemberList() {
		//1.
//		List<MemberVo> list = memberDao.selectMemberList();	
//		return list;
		
//		분리를 하는 이유 : 이 위치(핵심 비지니스 로직)에 작성되는 코드를
//		사용자 UI, DB와 분리시키기 위해서
		
		return memberDao.selectMemberList();
	}

	@Override
	public int insertMember(MemberVo vo) {
		return memberDao.insertMember(vo);
	}

	@Override
	public void deleteMember(String memId) {
		memberDao.deleteMember(memId);
	}

	@Override
	public MemberVo selectMember(String memId) {
		return memberDao.selectMember(memId);
	}

	@Override
	public MemberVo selectLoginMember(MemberVo memberVo) {
		return memberDao.selectLoginMember(memberVo);
	}

	@Override
	public void updateMember(MemberVo vo) {
		memberDao.updateMember(vo);
	}
	
}