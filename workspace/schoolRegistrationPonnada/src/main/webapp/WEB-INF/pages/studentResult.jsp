<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> <h2>Student Registration Result</h2>
    <table>
        <tr>
            <td>First Name</td>
            <td>${s.studentFirstName}</td>
        </tr>
        <tr>
            <td>Last name</td>
            <td>${s.studentLastName}</td>
        </tr>
        <tr>
            <td>Teacher Name</td>
            <td>${s.studentTeacherName}</td>
        </tr>
        <tr>
            <td>Subject</td>
            <td>${s.studentSubject}</td>
        </tr>
    </table>
<a href = "viewAll.mvc">View all Students</a>
</body>
</html>