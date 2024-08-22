<%@page import="java.util.Base64"%>
<%@page import="Com.Entity.JobApplicationFormEntity"%>
<%@page import="java.util.List"%>
<%@page import="Com.JdbcConnection.JdbcConnection"%>
<%@page import="Com.Module.Promodule"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="Header.jsp" %>
    <%@ include file="LeftNavigationBar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<main id="main" class="main">
	<section class="section">
	<table class="table datatable">
                <thead>
                  <tr>
                  <td> User Id </td>
                  <td> Job Title </td>
                  <td> User Name </td>
                  <td> User Email </td>
                 <td> User Contact </td>
                 <td> User Education </td>
                <td> User Resume </td>
                 <td> Skills </td>
                  </tr>
                  </thead>
                 
             <%
             try
             {
            	 Promodule P = new Promodule(JdbcConnection.getConnection());
            	 List<JobApplicationFormEntity> l = P.allrecord();
            	 for(JobApplicationFormEntity ja:l)
            	 {
             %>
             
             <tr>
             <td> <%=ja.getJobApplicationId() %> </td>
             <td> <%=ja.getJobTitle() %> </td>
             <td> <%=ja.getJobApplicationUserName() %> </td>
             <td> <%=ja.getJobApplicationUserEmail() %> 
             <td> <%=ja.getJobApplicationUserContact() %> </td>
             <td> <%=ja.getUserEducation() %> </td>
             <td>  <button>  <a href="DownloadResume?UserId=<%= ja.getJobApplicationId()%>">Download</a></button> </td>
            
             <td> <%=ja.getJobApplicationUserAreaOfExpertise() %> </td>
             
             <td> <button> <a href="UserAdd.jsp?UserId=<%= ja.getJobApplicationId()%>"> Accept </a></button> </td>
             <td> <button> <a href="RejectApplicationSer?Id=<%=ja.getJobApplicationId()%>"> Reject </a></button> </td>
             </tr>
             
             <%
            	 }
             }
             catch(Exception e)
             {
            	 e.printStackTrace();
             }
             %>
	 </table>
	</section>
	</main>
</body>
</html>