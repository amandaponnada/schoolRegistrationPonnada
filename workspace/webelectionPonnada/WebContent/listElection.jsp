<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ page import="model.electionDAO" %>
	<%@ page import="model.electionDB" %>
	<%@ page import="java.util.ArrayList" %>
<%ArrayList<electionDB> electionList = (ArrayList<electionDB>)request.getAttribute("curElections"); %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Available Elections</title>
</head>
<body>
<form method="post" action="listElectionServlet">
<h1> Select and existing Election</h1>
<div style="overflow:scroll;height:200px;width:50%;overflow:auto">
	<table border=1 cellpadding=5>
	
		<%
			for(int i=0; i < electionList.size(); i++) {
				electionList.get(i).getElectionName();
		%>
	
		<tr>
			<td><input type="radio" name = "eIndex" value="<%= electionList.get(i).getElectionID() %>"></td>
			<td><%=electionList.get(i).getElectionName() %></td>
		</tr>
		<%
			}
		%>
	</table>
</div>
<table>
	<tr>
        <td colspan="2" align="center"><input type="submit" name="LIST" value="VOTE NOW"></td>
        <td colspan="2" align="center"><input type="submit" name="LIST" value="BACK TO MAIN"></td>
    </tr> 
</table>

</form>

</body>
</html>