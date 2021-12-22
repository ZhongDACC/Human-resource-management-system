			

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%--引入核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul id="navigation" class="fl navline">	
<c:forEach items="${ menus}" var="m">
<li><a href="${m.menuURL301 }">${m.menuName301 }</a><li>
</c:forEach>
</ul>
























			