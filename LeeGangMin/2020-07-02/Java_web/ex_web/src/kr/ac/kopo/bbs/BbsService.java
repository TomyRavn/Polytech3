package kr.ac.kopo.bbs;

import java.util.List;

public interface BbsService {

	List<BbsVo> selectBbsList();

	int insertBbs(BbsVo vo);

	void deleteBbs(int bbsNo);

	BbsVo selectBbs(int bbsNo);

	void updateBbs(BbsVo vo);

}