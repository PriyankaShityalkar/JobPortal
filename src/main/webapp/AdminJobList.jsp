<%@page import="java.util.Base64"%>
<%@page import="Com.Entity.JobDetailsEntity"%>
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
                <td> Job Id </td>
                <td> Company Logo</td>
                <td> Job Title </td>
                <td> Job Location </td>
                <td> Job Type </td>
                <td> Job Salary </td>
                <td> Job Description </td>
                <td> Job Responsibility </td>
                <td> Job Qualification </td>
                <td> Job Summary </td>
                <td> Company Details </td>
                <td> Job DateLine </td>
                </tr>
                </thead>
                
                <%
                try
                {
                	Promodule P = new Promodule(JdbcConnection.getConnection());
                	List<JobDetailsEntity> l = P.fetch();
                	for(JobDetailsEntity jd:l)
                	{
                %>
                <tr>
                <td> <%=jd.getJobId() %> </td> 
                <td><img src="data:image/jpeg;base64,<%=Base64.getEncoder().encodeToString(jd.getCompanyLogo()) %>" style="height: 100px;width: 100px; "></td>
			 <td>
                <td> <%=jd.getJobTitle() %> </td>
                <td> <%=jd.getJobLocation() %> </td>
                <td> <%=jd.getJobType() %> </td>
                <td> <%=jd.getJobSalary() %> </td>
                <td> <%=jd.getJobDescription() %> </td>
                <td> <%=jd.getJobResponsibility() %> </td>
                <td> <%=jd.getJobQualification() %> </td>
                <td> <%=jd.getJobSummary() %> </td>
                <td> <%=jd.getJobCompanyDetail() %> </td>
                <td> <%=jd.getJobDateLine() %> </td>
                <td> 
                <button> <a href="Updatedetails.jsp?JobId=<%= jd.getJobId()%>"> Update </a> </button> </td>
                <td> <button> <a href="DeleteJobDetailsServlet?JobId=<%= jd.getJobId()%>"> Delete </a> </button>
                </td>
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