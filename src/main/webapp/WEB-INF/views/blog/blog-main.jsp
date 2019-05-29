<!-- JSTL 사용을 위한 태그 라이브러리 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- 스프링에서 제공하는 태그 라이브러리 -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 폼을 만들어주는 태그 라이브러리 -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />



		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>Spring Camp 2016 참여기</h4>
					<h1>${ids }</h1>
					<p>${content }
					<p>
				</div>
				<ul class="blog-list">
					<li><a href="">Spring Camp 2016 참여기</a> <span>2015/05/02</span>
					</li>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img
					src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>

			<c:set var='count' value='${fn:length(categoryList) }' />
				<ul>
			<c:forEach items='${categoryList }' var='categoryvo' varStatus='status'>
					<li><a href="${pageContext.request.contextPath}/blog/${categoryvo.id }/${categoryvo.no}">${categoryvo.name } </a></li>
			</c:forEach>
				</ul>
		</div>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />

	</div>
</body>
</html>