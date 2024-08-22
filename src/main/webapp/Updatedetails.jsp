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
<%
	try
	{
		int id = Integer.parseInt(request.getParameter("JobId"));
		Promodule P = new Promodule(JdbcConnection.getConnection());
		List<JobDetailsEntity> l = P.CheckJobId(id);
		for(JobDetailsEntity jd:l)
		{
%>

	
	<form action="UpdateDetailsServlet" method="post" enctype="multipart/form-data">
	<div class="row">
	<div class="col-md-6">
	<input type="hidden" name="id" value="<%=jd.getJobId() %>">
	</div>
	</div>
	<div class="row">
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Company Logo </b></label>
		<div class="col-sm-10">
		<td><img src="data:image/jpeg;base64,<%=Base64.getEncoder().encodeToString(jd.getCompanyLogo()) %>" style="height: 100px;width: 100px; "></td>
    	    <div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Company Logo </b></label>
		<div class="col-sm-10">
    	   <input type="file" name="img" accept="Image/*">
    	</div>
	</div> 
    	</div>
	</div>
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b>  Job Title  </b></label>
        <div class="col-sm-10">
         <input type="text" class="form-control" id="inputex" name="title" value="<%=jd.getJobTitle()%>">
        </div>
	</div>
	</div>
		
	<div class="row">
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Job Location </b> </label>
		<div class="col-sm-10">
    	   <input type="text" class="form-control" id="inputex" name="location" value="<%=jd.getJobLocation()%>">
    	</div>
	</div>
	
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Job Type </b></label>
        <div class="input-group has-validation">
                        <input type="text" id="floatingSelect" name="type" value="<%=jd.getJobType()%>">
                      </div>
	</div>
	</div>
    
    <div class="row">
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Job Salary </b> </label>
		<div class="col-sm-10">
    	   <input type="text" class="form-control" id="inputex" name="salary" value="<%=jd.getJobSalary()%>">
    	</div>
	</div>
	
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Job Description </b></label>
        <div class="col-sm-10">
         <input type="text" class="form-control" id="inputex" name="description" value="<%=jd.getJobDescription()%>">
        </div>
	</div>
	</div>
	
	<div class="row">
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Job Responsibility </b></label>
		<div class="col-sm-10">
    	   <input type="text" class="form-control" id="inputex" name="responsibility" value="<%=jd.getJobResponsibility()%>">
    	</div>
	</div>
	
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Job Qualification </b></label>
        <div class="col-sm-10">
         <input type="text" class="form-control" id="inputex" name="qualification" value="<%=jd.getJobQualification()%>">
        </div>
	</div>
	</div>
	
	<div class="row">
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b>Job Summary </b></label>
		<div class="col-sm-10">
    	   <input type="text" class="form-control" id="inputex" name="summary" value="<%=jd.getJobSummary()%>">
    	</div>
	</div>
	
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Job Company Detail </b></label>
        <div class="col-sm-10">
         <input type="text" class="form-control" id="inputex" name="detail" value="<%=jd.getJobCompanyDetail()%>">
        </div>
	</div>
	</div> 
	
	<div class="row">
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b>Job Date Line </b></label>
		<div class="col-sm-10">
    	   <input type="text" class="form-control" id="inputex" name="dateline" value="<%=jd.getJobDateLine()%>">
    	</div>
	</div>
	</div>
	
	<div class="row">
	<div class="col-md-6"> 
	<button type="submit"> Submit </button>
	</div>
	</div>    
	

<%
		}
	}
catch(Exception e)
{
	e.printStackTrace();	
}
%>
</form>
	</section>
	</main>
</body>
</html>