package kr.ac.kopo.bbs;

import java.util.List;

public class BbsServiceImpl implements BbsService{

	//private BbsDao bbsDao = new BbsDaoBatis();
	
	private BbsServiceImpl() {}
	private static BbsService bbsService = new BbsServiceImpl();
	public static BbsService getInstance() {
		return bbsService;
	}
	
	private BbsDao bbsDao = BbsDaoBatis.getInstance();
	
	@Override
	public List<BbsVo> selectBbsList() {
		return bbsDao.selectBbsList();
	}

	@Override
	public int insertBbs(BbsVo vo) {
		return bbsDao.insertBbs(vo);
	}

	@Override
	public void deleteBbs(int bbsNo) {
		bbsDao.deleteBbs(bbsNo);
	}

	@Override
	public BbsVo selectBbs(int bbsNo) {
		return bbsDao.selectBbs(bbsNo);
	}

	@Override
	public void updateBbs(BbsVo vo) {
		bbsDao.updateBbs(vo);
	}

}