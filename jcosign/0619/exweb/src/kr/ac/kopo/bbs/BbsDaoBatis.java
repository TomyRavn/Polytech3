package kr.ac.kopo.bbs;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import kr.ac.kopo.comm.MyBatisUtils;

public class BbsDaoBatis implements BbsDao{
	private SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();


	@Override
	public List<BbsVo> selectBbsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BbsVo selectBbs(int bbsNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBbs(BbsVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBbs(BbsVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBbs(int BbsNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}