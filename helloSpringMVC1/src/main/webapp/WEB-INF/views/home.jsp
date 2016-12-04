<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<p> 1. <a href="${pageContext.request.contextPath}/CreditKindOfSemester"> 학기별 학점 보기 </a>
<p> 2. <a href="${pageContext.request.contextPath}/CreditKindOfDivision"> 종류별 학점 보기 </a>
<p> 3. <a href="${pageContext.request.contextPath}/registercourses"> 수강신청 </a>
<p> 4. <a href="${pageContext.request.contextPath}/registeredcourses"> 수강신청된 과목보기 </a>

</body>
</html>
