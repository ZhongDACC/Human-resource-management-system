<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加导航菜单界面</title>
</head>
<body>
 <h1>添加菜单</h1>
 <form action="MenuServlet301?method=addMenu" method="post">
  序号<input type="text" name="menuNo301" /><br>
  名称<input type="text" name="menuName301" /><br>
  地址<input type="text" name="menuURL301" /><br>
  <input type="submit" value="添加"/>
 </form>
</body>
</html>
