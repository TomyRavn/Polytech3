/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.34
 * Generated at: 2020-06-03 09:37:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public final class stuList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "com";
	String password = "com01";
	
	String str_no = "stu_no";
	String str_name = "stu_name";
	String str_asc = "ASC";
	String str_desc = "DESC";
	
	boolean sort_stuName = true;
	boolean sort_DESC = true;
	String subject_now = str_name;
	String sort_now = str_desc;

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.sql.SQLException");
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
    _jspx_imports_classes.add("java.sql.DriverManager");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
 
	//학생목록을 다음과 같은 표 형태로 출력하고,
	//'학번'을 클릭하면 학번순으로 정렬하여 출력하고,
	//'이름'을 클릭하면 이름순으로 정렬하여 출력
	//학번   이름
	//1234 포로리
	
	//'학번' 기준으로 정렬된 상태에서 '학번'을 다시 클릭하면,
	//오름차순과 내림차순을 번갈아서 정렬
	//'이름' 기준으로 정렬된 상태에서 '이름'을 다시 클릭하면
	//오름차순과 내림차순을 번갈아서 정렬

      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!DOCTYPE html>       \r\n");
      out.write("\t\t<html>                \r\n");
      out.write("\t\t<head>                \r\n");
      out.write("\t\t<meta charset='UTF-8'>\r\n");
      out.write("\t\t<title>학생관리</title>\r\n");
      out.write("\t\t<style>\r\n");
      out.write("\t\ta, a:visited{\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t\tcolor:black;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttd {\r\n");
      out.write("\t\ttext-align:center;\r\n");
      out.write("\t\tborder: 1px solid #aaa;\r\n");
      out.write("\t\tcolor:black;\r\n");
      out.write("\t\t} \r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t\t</head>               \r\n");
      out.write("\t\t<body>                \r\n");
      out.write("\t\t\t<h1>학생목록</h1> \r\n");
      out.write("\t\t<a href= '");
      out.print( request.getContextPath() );
      out.write("/student/stuAddForm.jsp'><button>학생추가</button></a></br></br>\r\n");
      out.write("\t\t\r\n");

		if(sort_stuName){sort_stuName = false; subject_now = str_name; sort_now = str_asc;}
		else{sort_stuName = true; subject_now = str_name; sort_now = str_desc;}

		if(sort_DESC){sort_DESC = false; subject_now = str_no; sort_now = str_asc;}
		else{sort_DESC = true; subject_now = str_no; sort_now = str_desc;}
		
		String sql = "SELECT stu_no, stu_name, stu_score FROM student ORDER BY " + subject_now + " " + sort_now;
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){

      out.write("\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<a href='");
      out.print( request.getContextPath() );
      out.write("/student/stuList.jsp'><b>학번</b></a>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<a href='");
      out.print( request.getContextPath() );
      out.write("/student/stuList.jsp'><b>이름</b></a>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t성적\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");

			while(rs.next()) {
				String stuNo = rs.getString("stu_no");
				String stuName = rs.getString("stu_name");
				int stuScore = rs.getInt("stu_score");

      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<a href='");
      out.print( request.getContextPath() );
      out.write("/student/stuEditForm.jsp?stuNo=");
      out.print( stuNo );
      out.write("'><b>");
      out.print( stuNo );
      out.write("</b></a>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");
      out.print( stuName );
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");
      out.print( stuScore );
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\r\n");

			}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t</table>\r\n");

		} catch (SQLException e) {
			e.printStackTrace();
		}

      out.write("\r\n");
      out.write("\t\t</body>\r\n");
      out.write("\t\t</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}