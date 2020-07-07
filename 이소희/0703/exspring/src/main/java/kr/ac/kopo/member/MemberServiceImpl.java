package kr.ac.kopo.member;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

//이 객체를 서비스 역할을 하는 객체로서 memberService라는 이름으로 스프링에 등록
@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Resource(name = "memberDao")
	private MemberDao memberDao;
	
	@Override
	public List<MemberVo> selectMemberList() {
		return memberDao.selectMemberList();
	}

	@Override
	public int insertMember(MemberVo vo) {
		return memberDao.insertMember(vo);
	}

	@Override
	public int deleteMember(String memId) {
		return memberDao.deleteMember(memId);
	}

	@Override
	public MemberVo selectMember(String MemId) {
		return memberDao.selectMember(MemId);
	}

	@Override
	public int updateMember(MemberVo vo) {
		return memberDao.updateMember(vo);
	}

	@Override
	public MemberVo selectLoginMember(MemberVo memberVo) {
		return memberDao.selectLoginMember(memberVo);
	}

}
