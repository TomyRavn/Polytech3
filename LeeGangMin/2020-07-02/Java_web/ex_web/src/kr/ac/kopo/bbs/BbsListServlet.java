package kr.ac.kopo.bbs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bbs/list.do")
public class BbsListServlet extends HttpServlet{


	private BbsService bbsService = BbsServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BbsVo> bbsList = bbsService.selectBbsList();
		req.setAttribute("bbsList", bbsList);

		req.getRequestDispatcher("/WEB-INF/jsp/bbs/bbsList.jsp").forward(req, resp);
	}

}