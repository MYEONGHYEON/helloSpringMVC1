<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/result.css">
<title>Inquiry of completed credit by semester</title>
</head>
<body>

	<table>
		<tr>
			<th>년도</th>
			<th>학기</th>
			<th>이수학점</th>
			<th>상세보기</th>
		</tr>
		<c:forEach var="course" items="${coursecredit}">
			<tr>
				<td> ${course.year} </td>
				<td> ${course.semester} </td>
				<td> ${course.credit} </td>
				<td> <a href="${pageContext.request.contextPath}/CourseKindOfSemester?year=${course.year}&semester=${course.semester}"> 링크 </a> </td>
			</tr>
		</c:forEach>
	</table>
	
	<a class="page" href="${pageContext.request.contextPath}"> 메뉴로 갑니다 </a>

</body>
</html>