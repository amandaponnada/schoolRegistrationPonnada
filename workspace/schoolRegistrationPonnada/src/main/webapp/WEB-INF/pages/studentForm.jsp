<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ page isELIgnored="false" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<title>Spring MVC Form Handling</title>
</head>
<body>
<h2>Student Registration Form</h2>
<mvc:form modelAttribute="student" action="result.mvc">
	<table>
	    <tr>
	        <td><mvc:label path="studentFirstName">First Name</mvc:label></td>
	        <td><mvc:input path="studentFirstName" /></td>
	    </tr>
	    <tr>
	        <td><mvc:label path="studentLastName">Last Name</mvc:label></td>
	        <td><mvc:input path="studentLastName" /></td>
	    </tr>
	    <tr>
	        <td><mvc:label path="studentTeacherName">Teacher's Name</mvc:label></td>
	        <td><mvc:input path="studentTeacherName" /></td>
	    </tr>
   	    <tr>
	        <td><mvc:label path="studentSubject">Subject</mvc:label></td>
	        <td><mvc:textarea path="studentSubject" /></td>
	    </tr>
        <tr>
	        <td colspan="2">
                <input type="submit" value="Submit" />
	        </td>
	    </tr>
	</table>  
</mvc:form>
<a href = "viewAll.mvc">View all Students</a>
</body>
</html>