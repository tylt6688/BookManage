<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h2{text-align:center;}
	h3{text-align:center;}
	div{margin-top:50px;}
	form{margin-left:570px;}
	.right{
		margin-left:238px;
	}
</style>
</head>
<body>
<div>
	<h2>删除图书</h2>
	<form action="BookServlet?method=deleteBook" method="post">
		请输入要删除的图书ID:<input type="text" name="bookid"/><br/><br/>
		<input type="submit" name="submit" value="确认删除" class="right"/>
	</form>
	<h3>${result}</h3>
</div>
</body>
</html>