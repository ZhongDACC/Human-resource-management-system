<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,com.caohongtao301.pojo.Menu301"
    %>
    <%--引入核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String title="202025220301曹洪涛";
request.setAttribute("name",title);
request.setAttribute("info","202025220301曹洪涛6 ");
List<Menu301> menuList=new ArrayList<Menu301>();
/* menuList.add(new Menu301(1,"首页","index.jsp"));
menuList.add(new Menu301(2,"关于我们","article.jsp"));
menuList.add(new Menu301(3,"联系我们","list.jsp"));
menuList.add(new Menu301(4,"人才招聘","brand.jsp"));
menuList.add(new Menu301(4,"问题反馈","brand.jsp")); */
request.setAttribute("menus",menuList);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>JSTL基本应用-<%=title %></title>
</head>
<body>
<h2><c:out value="${info}"/></h2>
<c:forEach items="${menus }" var="m">
<a href="${m.menuURL301 }">${m.menuName301 }</a>
</c:forEach>

</body>
</html>