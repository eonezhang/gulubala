<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/common/include/header.jsp"%>
	<title>首页</title>
</head>
<body>
	<div>
		<h1>Welcome! ${not empty sessionScope.user ? sessionScope.user : ''}</h1>
		<c:if test="${empty sessionScope.user}">
			<p><a href="${CONTEXT_PATH}/register">去注册?</a></p>
		</c:if>
	</div>
	<script type="text/javascript" src="${CONTEXT_PATH}/resources/js/jquery-1.11.2.min.js"></script>
</body>
</html>