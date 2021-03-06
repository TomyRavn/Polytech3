package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exchange.do")			//언제 실행이 되느냐 -> exchange.do로 가라고 했을 때 실행
public class ExchangeServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		String dollar = req.getParameter("dollar");
		double dollarConvert = Double.parseDouble(dollar);
		
		//HTML 파일 복사 붙여넣기
		out.println("<!DOCTYPE html>                  	  ");
		out.println("<html>                           	  ");
		out.println("<head>                           	  ");
		out.println("<meta charset='UTF-8'>           	  ");
		out.println("<title>Insert title here</title> 	  ");
		out.println("</head>                          	  ");
		out.println("<body>                           	  ");
		
		if(dollarConvert>=0) {
			out.printf("<h1>%s달러=%.2f원</h1><br />", dollar, dollarConvert * 1216.90);
			out.printf("<h1>현찰 사실 때 : %s달러=%.2f원</h1><br />", dollar, dollarConvert * 1238.19);
			out.printf("<h1>현찰 파실 때 : %s달러=%.2f원</h1><br />", dollar, dollarConvert * 1195.61);
			out.printf("<h1>송금 보내실 때 : %s달러=%.2f원</h1><br />", dollar, dollarConvert * 1228.80);
			out.printf("<h1>송금 받으실 때 : %s달러=%.2f원</h1>", dollar, dollarConvert * 1205.00);
		}
		
		out.println("</body>                          	  ");
		out.println("</html>                          	  ");
	}
}