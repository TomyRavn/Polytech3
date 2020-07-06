<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!--@WebServlet("/hello.jsp")
	public class MemberEditFormServlet extends HttpServlet{    
	
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			resp.setContentType("text/html"); 	
			resp.setCharacterEncoding("UTF-8"); 
			PrintWriter out = resp.getWriter();  
			밑에 html문서를 out.println으로 묶어줌 
			out.println(<!DOCTYPE html>);-->   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello JSP</h1>
	JSP는 Servlet과 같다.
	JSP파일을 받으면 톰캣 서블릿으로 변환하여 출력해줌	</br>
	<%--JSP 내에서 실행하고 싶은 JAVA 코드를<% %> 태그 내부에 작성 --% ↓ 새로고침 할때마다 한번씩 실행--%>
	<%		
		int a = 3;
		int b = 4;
		int c = a + b;
		//PrintWriter out = resp.getWriter(); 이미 출력이 되있음.
		//JSP내에서는 별도의 선언 없이 사용가능한 기본객체들이 존재
		//request (요청객체), response(응답객체),out(응답객체에출력하는스트림) 등		
		out.println( "a+b=" + c );
	%>
	</br>
	a + b = <%out.println(c); %></br>
	a + b = <%=c%></br>
	<%-- 표현식 :JAVA 코드를 실행한 결과를 현재 위치에 출력하고 싶은 경우<%=%> 사용가능--%>
	
	<%--요청이 올때마다 실행되는 service()메서드 외부에 위치해야하는 자바코드는 <%!%> 사용--%>
	
	<%!
	private int x = 10;
	
	
	%>
		
</body>
</html>
