package kr.ac.kopo.member;

import java.util.List;

public interface MemberDao {

	List<MemberVo> selectMemberList();

	int insertMember(MemberVo vo);

	int deleteMember(String memId);

	MemberVo selectMember(String MemId);

	int updateMember(MemberVo vo);

	MemberVo selectLoginMember(MemberVo memberVo);

}