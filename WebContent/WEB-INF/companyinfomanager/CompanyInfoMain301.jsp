<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公司信息管理界面</title>
</head>
<body>
<a href="AddCompanyInfo301.jsp">添加公司信息</a>
<table border="1">
<tr><th>编号</th><th>序号</th><th>标题</th><th>内容</th><th>图片</th><th>日期</th><th colspan="2">编辑</th></tr>
<c:forEach items="${ciList}" var="ci">
 <tr><td>${ci.ciId301}</td><td>${ci.ciNo301}</td><td>${ci.ciTitle301 }</td><td width="50%">${ci.ciContent301}</td><td>${ci.ciImage301}</td><td>${ci.ciEditDate301}</td>
 <td><a href="companyInfoController301?method=editCompanyInfo&ciId301=${ci.ciId301}">编辑</a></td>
 <td><a href="companyInfoController301?method=deleteCompanyInfo&ciId301=${ci.ciId301}" onclick="return confirm('是否确认删除？')">删除</a></td>
 </tr>
</c:forEach>
</table>
</body>
</html>