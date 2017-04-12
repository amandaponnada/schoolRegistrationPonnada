<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ page import="model.electionDAO" %>
	<%@ page import="model.electionDB" %>
	<% electionDB voteElection=(electionDB)request.getAttribute("voteElection"); %>	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VOTING PANEL</title>
</head>
<body>
<form action="voteElectionServlet" method="post">
<table align="center" bgcolor="#99FFCC" border="1" width="30%">
    <tr>
        <td colspan="3" align="center">CAST YOUR VOTE</td>
    </tr>
    <tr>
	        <td colspan="3" align="center"><input type="hidden" name="eId" value="<%=voteElection.getElectionID()%>"><%=voteElection.getElectionName() %></td>
    </tr>
    <tr>
    	<td style="padding-left: 50px;" colspan="3" align="left" ><input type="radio" name="voteCandidate" value="candidate1"><%=voteElection.geteCandidate1Name() %></td>
    </tr>
    <tr>
    	<td style="padding-left: 50px;" colspan="3" align="left"><input type="radio" name="voteCandidate" value="candidate2"><%=voteElection.geteCandidate2Name() %></td>
    </tr>
    <tr>
    	<td style="padding-left: 50px;" colspan="3" align="left"><input type="radio" name="voteCandidate" value="candidate3"><%=voteElection.geteCandidate3Name() %></td>
    </tr> 
    <tr>
        <td colspan="1" align="center"><input type="submit" name="VOTE" value="CAST"></td>
        <td colspan="1" align="center"><input type="submit" name="VOTE" value="BACK"></td>
        <td colspan="1" align="center"><input type="submit" name="VOTE" value="RESULTS"></td>
   </tr> 
</table>
</form>
</body>
</html>