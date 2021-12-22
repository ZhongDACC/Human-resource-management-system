<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>更新导航菜单信息界面</title>
</head>
<body>
	<h1>更新菜单</h1>
	<form action="MenuServlet301?method=updateMenu" method="post">
		<input type="hidden" name="id301" value="${menu.id301 }"/><br> 
		序号<input type="text" name="menuNo301" value="${menu.menuNo301 }"/><br>
		名称<input type="text" name="menuName301" value="${menu.menuName301 }"/><br>
		地址<input type="text" name="menuURL301" value="${menu.menuURL301 }"/><br>
		<input type="submit" value="修改"/>
	</form>
</body>
</html>