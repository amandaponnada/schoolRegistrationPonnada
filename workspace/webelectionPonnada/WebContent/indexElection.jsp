<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ponnada Voting Management Application</title>
</head>
<body>
<form method="POST" action="indexElectionServlet">
<table align="center" border="1" width="25%">
	<tr> 
		<td colspan="2" align="center">Ponnada Election Management Application</td>
	</tr>
	<tr> 
		<td colspan="2" align="left"><input type="radio" name="radios" value="newPoll">Create a new Poll</td>
	</tr>
	<tr> 
		<td colspan="2" align="left"><input type="radio" name="radios" value="curPoll">View existing Polls</td>
	</tr>
    <tr>
        <td colspan="2" align="center"><input type="submit" name="ENTER" value="SUBMIT"></td>
    </tr> 
</table>
</form>
</body>
</html>