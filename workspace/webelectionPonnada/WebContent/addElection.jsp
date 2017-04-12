<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a new Election</title>
</head>
<body>
<form action="addElectionServlet" method="post">
<table align="center" bgcolor="#99FFCC" border="1" width="70%">
    <tr>
        <td colspan="2" align="center">Election Details</td>
    </tr>
    <tr>
        <td>Election Name</td>
        <td><input type="text" name="eName" maxlength="25"></td>
    </tr>
    <tr>
        <td>1. Candidate Name </td>
        <td><input type="text" name="candidate1Name" maxlength="40"></td>
    </tr>
    <tr>
        <td>2. Candidate Name</td>
        <td><input type="text" name="candidate2Name" maxlength="40"></td>
    </tr>
    <tr>
        <td>3. Candidate Name</td>
        <td><input type="text" name="candidate3Name" maxlength="40"></td>
    </tr> 
    <tr>
        <td colspan="2" align="center"><input type="submit" value="Submit"></td>
    </tr> 
</table>
</form>
</body>
</html>