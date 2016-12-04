<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/result.css">
<title>Inquiry of course by semester</title>
</head>
<body>

	<table>
		<tr>
			<th>년도</th>
			<th>학기</th>
			<th>교과코드</th>
			<th>교과목명</th>
			<th>구분</th>
			<th>학점</th>
		</tr>
		<c:forEach var="course" items="${coursecredit}">
			<tr>
				<td>${course.year}</td>
				<td>${course.semester}</td>
				<td>${course.courseCode}</td>
				<td>${course.courseName}</td>
				<td>${course.kind}</td>
				<td>${course.credit}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a class="page" href="${pageContext.request.contextPath}/CreditKindOfSemester"> 이전 페이지로 갑니다 </a>

</body>
</html>