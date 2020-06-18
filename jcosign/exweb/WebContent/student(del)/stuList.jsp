<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
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
%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원관리</title>
<meta http-equiv='cache-control' content='no-cache'/>
<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
<title>Table Sorter</title>
<script>
/*
 Ascendeing / Descending, IF 문 이용, nextSibling
 */
 var data = [
     ['순서','학번','이름','성적'],
     ['1', 80, 70, 30],
     ['2', 90, 60, 80],
     ['3', 70, 70, 70],
     ['4', 50, 90, 90]
     
    ];

window.onload = function(){
    var table = document.createElement('table');
    var targetPn = document.getElementById ('targetPn');
    targetPn.appendChild(table);
    table.border = 1;
    table.width = 200;
    
    for (var i=0; i<data.length; i++){
        var tr = document.createElement('tr');
        table.appendChild(tr);
        for (var j=0; j<data[i].length; j++){
            var td = document.createElement('td');
            tr.appendChild(td);
            td.innerHTML = data[i][j];
        }
    }
}

var sortType = 'asc';
function sortTable(){
    sortType = (sortType === 'asc') ? 'desc':'asc';

    var table = document.getElementsByTagName('table');
    var rows = table[0].rows;
    var chkSort = true;
    
    while (chkSort){
        chkSort = false;
        for (var i = 1; i < (rows.length - 1); i++) {
            var row = rows[i];
            var fCell = row.cells[0].innerHTML.toLowerCase();
            var sCell = row.nextSibling.cells[0].innerHTML.toLowerCase();
            if ( (sortType === 'asc'  && fCell > sCell)             // innerHTML.toLowerCase() 중복 처리
              || (sortType === 'desc' && fCell < sCell) ) {
                row.parentNode.insertBefore(row.nextSibling, row);
                chkSort = true;
            }
        }    
    }
}

</script>
</head>
<body>
	<h1>회원추가</h1>
	
	<a href='<%= request.getContextPath() %>/student/stuAddForm.jsp'>추가</a><br />
	
<%
			String sql = "SELECT stu_no, stu_name, stu_score FROM student";
			try(
					Connection conn = DriverManager.getConnection(url, user, password);
					PreparedStatement pstmt = conn.prepareStatement(sql);	
					ResultSet rs = pstmt.executeQuery(); 
					)
					{
						while (rs.next()) {
							String stuNo = rs.getString("stu_no"); 
							String stuName = rs.getString("stu_name"); 
							int stuscore = rs.getInt("stu_score"); 
%>							
							<a href='<%= request.getContextPath() %>/student/stuEditForm.jsp?stuNo=<%=stuNo%>'>  <%=stuNo%>  </a>
							 : <%= stuName %>  :  <%= stuscore %>  							
							<br/>
<%							

						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
		
 %>
  <%--<button type='button' onclick='sortTable()'>Sort</button> --%>
  <button type='button' onclick='sortTable()'>정렬</button>
    <div id='targetPn' style='width:130px'>
    </div>

</body> 
</html>