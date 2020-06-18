package kr.ac.kopo.bbs;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bbs/add.do")
public class BbsAddServlet extends HttpServlet{
	BbsDaoJdbc bbsDao = new BbsDaoJdbc();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/bbs/bbsAdd.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		//여기부터
		String bbsTitle = req.getParameter("bbsTitle");
		String bbsContent = req.getParameter("bbsContent");
		String bbsWriter = req.getParameter("bbsWriter");
		
		if(!bbsTitle.equals("")){
		//여기까지는 값을 입력하지 않으면 글이 작성되지 않는 것
			
		BbsVo vo = new BbsVo();
		vo.setBbsTitle(req.getParameter("bbsTitle"));
		vo.setBbsContent(req.getParameter("bbsContent"));
		vo.setBbsWriter(req.getParameter("bbsWriter"));
		
		int num = bbsDao.insertBbs(vo);
		
		}
	
		
		resp.sendRedirect(req.getContextPath() + "/bbs/list.do");
		
//		req.getRequestDispatcher("/bbs/list.do").forward(req, resp);
	
	}
}