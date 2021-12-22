<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%--引入核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%--引入标签库 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String title = "202025220301曹洪涛";
request.setAttribute("info","202025220301曹洪涛6 ");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>JSTL基本应用-<%=title %></title>
</head>
<body>
<c:out value="${info}"></c:out>
<c:set var="score" scope="session" value="${99 }"/>
<c:if test="${score>90 }">
<h3>你的成绩为:<c:out value="${score }"/></h3>
</c:if>
</body>
</html>