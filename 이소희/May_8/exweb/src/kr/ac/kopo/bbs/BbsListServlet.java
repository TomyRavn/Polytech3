package kr.ac.kopo.bbs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.bbs.BbsDaoJdbc;
import kr.ac.kopo.bbs.BbsVo;


//게시물 목록에서 등록일이 2020/06/12 09:00:00와 같은 형태로 출력되도록 변경
//게시물 상세보기 화면에서 등록일을 2020년06월12일 09시00분00초 형태로 출력

	@WebServlet("/bbs/list.do")
	public class BbsListServlet extends HttpServlet {

		BbsDaoJdbc bbsDao = new BbsDaoJdbc();

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ArrayList<BbsVo> list = bbsDao.selectBbsList();

			req.setAttribute("bbsList", list);
				
			req.getRequestDispatcher("/META-INF/jsp/bbs/bbsList.jsp").forward(req, resp);

	}
	}
	