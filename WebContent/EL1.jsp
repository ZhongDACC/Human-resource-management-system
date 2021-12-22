<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    String title="202025220301曹洪涛";
    request.setAttribute("name",title);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL应用-<%=title %> </title>
</head>
<body>
<h1>姓名: ${name}<p>
年龄:${20+1}<p>
${30<=20 }
</h1>

</body>
</html>