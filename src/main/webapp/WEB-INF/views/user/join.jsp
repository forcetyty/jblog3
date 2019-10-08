<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<title>JBlog</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css"
	rel="stylesheet" type="text/css">
<script
	src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery-1.9.0.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {

		// 		$('#gender1').prop('checked', true);

		$("#input-id").change(function() {
			$("#btn-check-email").show();
			$("#img-checked").hide();
		});

		/* var btnCheckEamil = $("#btn-check-email"); */
		$("#btn-check-email")
				.click(
						function() {
							//console.log("!!!!!!!!!!!!!");
							var email = $("#input-id").val();

							if (email == "") {
								return;
							}

							// ajax 통신!!!
							$
									.ajax({
										url : "${pageContext.servletContext.contextPath }/api/user/checkemail?email="
												+ email,
										type : "get",
										dataType : "json",
										data : "",
										success : function(response) {
											if (response.result == "fail") {
												console.error(response.message);
												return;
											}

											if (response.data == true) {
												alert("이미 있는 아이디 입니다.");
												$("#input-id").val("");
												$("#input-id").focus();
												return;
											}

											$("#btn-check-email").hide();
											$("#img-checked").show();
											console.log("사용 가능합니다.")
										},
										error : function(xhr, error) {
											console.error("error:" + error);
										}
									});
						});
	});
</script>
</head>
<body>
	<div class="center-content">
		<h1 class="logo">JBlog</h1>
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<form class="join-form" id="join-form" method="post" action="${pageContext.servletContext.contextPath }/user/join">
			<label class="block-label" for="name">이름</label>
			<form:input path="name" />

			<spring:hasBindErrors name="userVo">
				<c:if test='${errors.hasFieldErrors("name") }'>
					<p
						style="font-weight: bold; color: red; text-align: left; padding-left: 0">
						<spring:message code='${errors.getFieldError("name").codes[0] }'
							text='${errors.getFieldError("name").defaultMessage }' />
					</p>
				</c:if>
			</spring:hasBindErrors>

			<label class="block-label" for="blog-id">아이디</label>
			<form:input path="blog-id" />

			<input id="btn-checkemail" type="button" value="id 중복체크"> 
			<img id="img-checkemail" style="display: none;"
				src="${pageContext.request.contextPath}/assets/images/check.png">

			<p
				style="font-weight: bold; color: red; text-align: left; padding: 5px 0 0 0">
				<form:errors path="blog-id" />
			</p>


			<label class="block-label" for="password">패스워드</label>
			<!-- <input id="password" name="password" type="password" /> -->
			<form:password path="password" />

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">

		</form>
	</div>
</body>
</html>
