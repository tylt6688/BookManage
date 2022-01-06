<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	<h2>修改图书</h2>
	<form action="BookServlet?method=updateBook" method="post">
		请输入要修改的图书ID:<br/>
		&nbsp;&nbsp;书号：<input type="text" name="bookid"/><br/><br/>
		请输入新的图书信息:<br/>
		&nbsp;&nbsp;书名：<input type="text" name="bookname"/><br/><br/>
		&nbsp;&nbsp;作者：<input type="text" name="author"/><br/><br/>
		&nbsp;&nbsp;价格：<input type="text" name="price"/><br/><br/>
		<input type="submit" name="submit" value="确认修改" class="right"/>
	</form>
	<h3>${result}</h3>
</div>
</body>
</html>