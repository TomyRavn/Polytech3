package kr.ac.kopo.bbs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	@WebServlet("/bbs/list.do")
	public class BbsListServlet extends HttpServlet {
		private BbsService bbsService = new BbsServiceImpl();

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			List<BbsVo> list = bbsService.selectBbsList();

			req.setAttribute("bbsList", list);
				
			req.getRequestDispatcher("/META-INF/jsp/bbs/bbsList.jsp").forward(req, resp);

	}
	}
	