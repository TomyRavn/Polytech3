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

//�Խù� ��Ͽ��� ������� 2020/06/12 09:58:37 �� ���� ���·� ��µǵ��� ����
//�Խù� �󼼺��� ȭ�鿡�� ������� 2020�� 6�� 12�� 9�� 58�� �� ���� ���·� ��µǵ��� ����

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
