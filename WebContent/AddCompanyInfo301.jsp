<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公司信息管理界面-添加公司信息</title>
</head>
<body>
<h1>添加公司信息</h1>
	<form action="companyInfoController301?method=addCompanyInfo" method="post">
		序号:<input type="text" name="ciNo301" /><br>
		标题:<input type="text" name="ciTitle301" /><br>
		图片:<input type="text" name="ciImage301" /><br>
		内容:<textarea name="ciContent301" rows="20" cols="50"></textarea><br>
		日期:<input type="text" name="ciEditDate301" /><br>
		<input type="submit" value="添加"/>
	</form>
</body>
</html>