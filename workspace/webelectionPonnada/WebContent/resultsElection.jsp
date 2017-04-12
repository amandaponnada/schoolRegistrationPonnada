<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ page import="model.electionDB" %>
	<% electionDB resultElection=(electionDB)request.getAttribute("resElection"); %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Poll Results</title>
</head>
<body>
<form action="resultElectionServlet" method="post">
<table align="center" bgcolor="#99FFCC" border="1" width="30%">
    <tr>
        <td colspan="3" align="center">RESULTS</td>
    </tr>
    <tr>
	        <td colspan="3" align="center"><%=resultElection.getElectionName() %></td>
    </tr>
    <tr>
    	<td style="padding-left: 50px;" colspan="3" align="left" ><%=resultElection.geteCandidate1Name()  + " " + resultElection.geteCandidate1Votes() %></td>
    </tr>
    <tr>
    	<td style="padding-left: 50px;" colspan="3" align="left"><%=resultElection.geteCandidate2Name() + " " + resultElection.geteCandidate2Votes()  %></td>
    </tr>
    <tr>
    	<td style="padding-left: 50px;" colspan="3" align="left"><%=resultElection.geteCandidate3Name() + " " + resultElection.geteCandidate3Votes()  %></td>
    </tr>
    <tr>
    	<td style="padding-left: 50px;" colspan="3" align="left" bgcolor="#f47742"><%="WINNER : " + resultElection.electionWinner()  %></td>
    </tr> 
    <tr>
        <td colspan="1" align="center"><input type="submit" name="RESULT" value="BACK TO MAIN"></td>
   </tr> 
</table>
</form>

</body>
</html>