<!-- JSTL 사용을 위한 태그 라이브러리 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- 스프링에서 제공하는 태그 라이브러리 -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 폼을 만들어주는 태그 라이브러리 -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
			<div id="content" class="full-screen">
				<c:import url='/WEB-INF/views/includes/adminMenubar.jsp'>
					<c:param name="menu" value="category" />
				</c:import>
				<table class="admin-cat">
					<tr>
						<th>번호</th>
						<th>카테고리명</th>
						<th>포스트 수</th>
						<th>설명</th>
						<th>삭제</th>
					</tr>
					<tr>
						<td>3</td>
						<td>미분류</td>
						<td>10</td>
						<td>카테고리를 지정하지 않은 경우</td>
						<td><img
							src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
					</tr>
					<tr>
						<td>2</td>
						<td>스프링 스터디</td>
						<td>20</td>
						<td>어쩌구 저쩌구</td>
						<td><img
							src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
					</tr>
					<tr>
						<td>1</td>
						<td>스프링 프로젝트</td>
						<td>15</td>
						<td>어쩌구 저쩌구</td>
						<td><img
							src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
					</tr>
				</table>

				<h4 class="n-c">새로운 카테고리 추가</h4>
				<form:form 
					modelAttribute="categoryVo" 
					class="category-form" 
					id="category-form"
					method="post" 
					action="${pageContext.request.contextPath}/${authUser.id }/admin/category">
					<input type="hidden" name="id" value="${authUser.id }">
					<table id="admin-cat-add">
						<tr>
							<td class="t">카테고리명</td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td class="t">설명</td>
							<td><input type="text" name="description"></td>
						</tr>
						<tr>
							<td class="s">&nbsp;</td>
							<td><input type="submit" value="카테고리 추가"></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />

	</div>
</body>
</html>