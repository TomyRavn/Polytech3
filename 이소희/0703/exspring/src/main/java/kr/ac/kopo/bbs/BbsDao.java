package kr.ac.kopo.bbs;

import java.util.List;

public interface BbsDao {

	List<BbsVo> selectBbsList();

	int insertBbs(BbsVo vo);

	BbsVo selectBbs(int bbsNo);

	int updateBbs(BbsVo vo);

	int deleteBbs(int bbsNo);

}