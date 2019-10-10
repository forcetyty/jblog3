<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css"
	rel="stylesheet" type="text/css">
<div id="header">
	<h1>${authUser.name }블로그</h1>
	<ul>
		<c:choose>
			<c:when test="${empty authUser }">
				<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
			</c:when>
			<c:otherwise>
				<li>${authUser.name }님안녕하세요</li>

				<li><a href="${pageContext.request.contextPath}/${authUser.id}">My
						Blog</a></li>
				<li><a
					href="${pageContext.request.contextPath}/blog/blog-admin-basic">블로그
						관리</a></li>
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>