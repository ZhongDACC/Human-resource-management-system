<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>导航菜单管理界面</title>
</head>
<body>
<a href="AddMenu301.jsp">添加导航菜单</a>
<table border="1">
<tr><th>编号</th><th>序号</th><th>名称</th><th>地址</th><th colspan="2">编辑</th></tr>
<c:forEach items="${menus}" var="m">
 <tr><td>${m.id301}</td><td>${m.menuNo301}</td><td>${m.menuName301 }</td><td>${m.menuURL301}</td>
 <td><a href="MenuServlet301?method=editMenu&id301=${m.id301}">编辑</a></td>
 <td><a href="MenuServlet301?method=deleteMenu&id301=${m.id301}" onclick="return confirm('是否确认删除？')">删除</a></td>
 </tr>
</c:forEach>
</table>
</body>
</html>