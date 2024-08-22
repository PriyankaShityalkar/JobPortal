<%@page import="java.util.ArrayList"%>
<%@page import="Com.Entity.UserRegistrationEntity"%>
<%@page import="java.util.List"%>
<%@page import="Com.JdbcConnection.JdbcConnection"%>
<%@page import="Com.Module.Promodule"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="LeftNavigationBar.jsp"%>
    <%@ include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <main id="main" class="main">
	<section class="section">
	<%-- <form action="RegisteredUserSr" method="post">  --%>
		<table class="table datatable">
                <thead>
                  <tr>
                    <th>  UserId </th>
                    <th>  UserName</th>
                    <th>  UserEmail</th>
                    <th>  UserPassword </th>
					<th>  UserMobileNumber </th>
					<th>  UserLocation </th>
					<th>  UserRegistrationFee </th>
                  </tr> 
                </thead>
                </tbody>
		<%
		try
		{
			Promodule P = new Promodule(JdbcConnection.getConnection());
			List<UserRegistrationEntity> l = P.Allrecords();
			for(UserRegistrationEntity ur:l)
			{
		%>
		
		<tr>
		<td> <%=ur.getUserId()%> </td>
		<td><%=ur.getUserName()%> </td>
		<td> <%=ur.getUserEmail()%> </td>
		<td> <%=ur.getUserPassword()%> </td>
		<td> <%=ur.getUserMobileNumber()%> </td>
		<td> <%=ur.getUserLocation()%> </td>
		<td> <%=ur.getUserRegistrationFee() %> </td>
		<td> 
                           <button> <a href="AddUserJSP.jsp?UserId=<%=ur.getUserId()%>">  Add </a></button>
        </td>
       <%--  <td> <button><a href="Delete?UserId=<%=ur.getUserId()%>"> Delete </a>  </button> </td> --%>
		</tr>
		<%
		}
	}
	catch(Exception E)
	{
		E.printStackTrace();
	}
	%>
	</table>
	
 </section>
 </main>
 
</body>
</html>