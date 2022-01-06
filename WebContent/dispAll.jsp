<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Caomei Liarbry</title>
<style>
	table,table tr th, table tr td { border:1px solid #87cefa; }
	a{text-decoration:none;}
</style>
</head>
<body>
<div style="width:500px;margin-left:480px;margin-top:50px;">
	<a href="addBook.jsp" style="margin-left:120px;">【添加图书信息】</a>
	<table style="margin-top:5px;">
		<tr style="background:#87CEEB;color:#fff;font-weight:bold;">
			<td>&nbsp;书号&nbsp;</td><td>&nbsp;书名&nbsp;</td><td>&nbsp;作者&nbsp;</td><td>&nbsp;价格&nbsp;</td><td>&nbsp;操作&nbsp;</td>
		</tr>
		<c:forEach var="bk" items="${books}">
			<tr style="border-top:1px solid blue;">
				<td>&nbsp;${bk.bookid }&nbsp;</td>
				<td>&nbsp;${bk.bookname }&nbsp;</td>
				<td>&nbsp;${bk.author }&nbsp;</td>
				<td>&nbsp;${bk.price }&nbsp;</td>
				<td>&nbsp;<a href="updateBook.jsp">修改</a>&nbsp;
				<a href="deleteBook.jsp">删除</a>&nbsp;</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>