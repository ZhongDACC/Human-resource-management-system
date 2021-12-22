<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公司信息管理界面-更新-${ci301.ciTitle301 }-界面</title>
</head>
<body>
<h1>更新《${ci301.ciTitle301 }》</h1>
	<form action="companyInfoController301?method=updateCompanyInfo" method="post">
		<input type="hidden" name="ciId301" value="${ci301.ciId301 }"/>
		序号:<input type="text" name="ciNo301" value="${ci301.ciNo301 }"/><br>
		标题:<input type="text" name="ciTitle301" value="${ci301.ciTitle301 }"/><br>
		图片:<input type="text" name="ciImage301" value="${ci301.ciImage301 }"/><br>
		内容:<textarea name="ciContent301" rows="20" cols="50">${ci301.ciContent301 }</textarea><br>
		日期:<input type="text" name="ciEditDate301" value="${ci301.ciEditDate301 }"/><br>
		<input type="submit" value="更新"/>
	</form>
</body>
</html>