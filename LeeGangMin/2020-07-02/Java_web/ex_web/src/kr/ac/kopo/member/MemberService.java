package kr.ac.kopo.member;

import java.util.List;

public interface MemberService {

	List<MemberVo> selectMemberList();

	int insertMember(MemberVo vo);

	void deleteMember(String memId);

	MemberVo selectMember(String memId);

//	MemberVo selectLoginMember(String memId, String memPass);

	MemberVo selectLoginMember(MemberVo memberVo);

	void updateMember(MemberVo vo);

}