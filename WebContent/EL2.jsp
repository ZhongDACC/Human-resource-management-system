<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,com.caohongtao301.pojo.Menu301"
    %>
    <%
    	String title="202025220301曹洪涛";
        request.setAttribute("name",title);
        List<Menu301> menuList=new ArrayList<Menu301>();
       /*  menuList.add(new Menu301(1,"首页","index.jsp"));
        menuList.add(new Menu301(2,"关于我们","article.jsp"));
        menuList.add(new Menu301(3,"联系我们","list.jsp"));
        menuList.add(new Menu301(4,"人才招聘","brand.jsp")); */
        request.setAttribute("menus",menuList);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EL应用-<%=title %> </title>
</head>
<body>
<h1>姓名: ${requestScope.name}
</h1>
<a href="${menus[0].menuURL301 }">${menus[0].menuName301 }</a>
<a href="${menus[1].menuURL301 }">${menus[1].menuName301 }</a>
<a href="${menus[2].menuURL301}">${menus[2].menuName301 }</a>
<a href="${menus[3].menuURL301 }">${menus[3].menuName301 }</a>

</body>
</html>