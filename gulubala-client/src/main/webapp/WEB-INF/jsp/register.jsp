<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/common/include/header.jsp"%>
	<title>注册</title>
</head>
<body>
	<div>
		<h1>Register</h1>
		<form action="${CONTEXT_PATH}/register/submit" method="post">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="userName"/></td>
				</tr>
				<tr>
					<td>手机号：</td>
					<td><input type="text" name="mobilePhone"/></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><input type="text" name="email"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="submit"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript" src="${CONTEXT_PATH}/resources/js/jquery-1.11.2.min.js"></script>
</body>
</html>