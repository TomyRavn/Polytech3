package kr.ac.kopo.member;

import java.util.List;

public interface MemberDao {

	List<MemberVo> selectMemberList();

	int insertMember(MemberVo vo);

	MemberVo selectMember(String memId);

	int updateMember(MemberVo vo);

	int deleteMember(String memId);

	MemberVo selectLoginMember(MemberVo memberVo);

}