package kr.ac.kopo.bbs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.bbs.BbsVo;

//게시물 목록에서 등록일이 2020/06/12 09:58:37 와 같은 형태로 출력되도록 설정
//게시물 상세보기 화면에서 등록일을 2020년 6월 12일 9시 58분 와 같은 형태로 출력되도록 설정

@WebServlet("/bbs/list.do")
public class BbsListServlet extends HttpServlet{
	
	BbsDao bbsDao = new BbsDaoBatis();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BbsVo> list = bbsDao.selectBbsList();
		
		req.setAttribute("bbsList", list);
		
		req.getRequestDispatcher("/WEB-INF/jsp/bbs/bbsList.jsp").forward(req, resp);

}
}
