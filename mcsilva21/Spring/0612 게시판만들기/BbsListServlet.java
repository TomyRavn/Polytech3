package kr.ac.kopo.bbs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//게시물 목록에서 등록일이 2020/06/12 09:58:37와 같은 형태로 출력되도록 변경
//게시믈 상세보기 화면에서 등록일을  2020년 6월 12일 9시 58분 37초와 같은 형태로 출력

@WebServlet("/bbs/list.do")
public class BbsListServlet extends HttpServlet{
	BbsDaojdbc bbsDao = new BbsDaojdbc();
			
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<BbsVo> list = bbsDao.selectBbsList();
		
		req.setAttribute("bbsList", list); //${bbsList}
				
		req.getRequestDispatcher("/WEB-INF/jsp/bbs/bbsList.jsp").forward(req,resp);				
	}
	
}
