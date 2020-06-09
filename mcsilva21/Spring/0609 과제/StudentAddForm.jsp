<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!DOCTYPE html>                 
   <html>                          
   <head>                          
   <meta charset='UTF-8'>          
   <title>학생 관리</title>
   </head>                         
   <body>                          
   
   
      <h1>학생 추가</h1>
   
         <form action='<%=request.getContextPath()%>/student/add.do' method='post'> 
         학번: <input text='text' name='stu_no'/><br/>                      
         이름: <input text='text' name='stu_name'/><br/>                    
         점수: <input text='text' name='stu_score'/><br/>                   
         <input type='submit' value='저장' />                               
   </form> 
   
   </body>                        
   </html>         