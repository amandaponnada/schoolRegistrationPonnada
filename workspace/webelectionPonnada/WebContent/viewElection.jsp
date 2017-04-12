<%@page import="model.electionDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Election Created</title>
</head>
<body>

<% electionDB viewElection=(electionDB)request.getAttribute("election"); %>
<form method="post" action="viewElectionServlet">
<table align="center" bgcolor="#99FFCC" border="1" width="70%">
    <tr>
        <td colspan="2" align="center">View Election</td>
    </tr>
    <tr>
        <td>Election Name</td>
        <td><%=viewElection.getElectionName() %></td>
    </tr>
    <tr>
        <td>1. Candidate Name </td>
        <td><%=viewElection.geteCandidate1Name() %></td>
    </tr>
    <tr>
        <td>2. Candidate Name</td>
        <td><%=viewElection.geteCandidate2Name() %></td>
    </tr>
    <tr>
        <td>3. Candidate Name</td>
        <td><%=viewElection.geteCandidate3Name() %></td>
    </tr> 
    <tr>
        <td colspan="2" align="center"><input type="submit" name="VIEWBACK" value="BACK TO MAIN"></td>
    </tr>     
</table>
</form>
</body>
</html>