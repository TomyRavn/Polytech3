package kr.ac.kopo.bbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bbs/list.do")
public class BbsListServlet extends HttpServlet{


	BbsDaoJdbc bbsDao = new BbsDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<BbsVo> bbsList = bbsDao.selectBbsList();
		req.setAttribute("bbsList", bbsList);

		req.getRequestDispatcher("/WEB-INF/jsp/bbs/bbsList.jsp").forward(req, resp);
	}

}