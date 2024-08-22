<%@page import="Com.Entity.JobApplicationFormEntity"%>
<%@page import="java.util.List"%>
<%@page import="Com.JdbcConnection.JdbcConnection"%>
<%@page import="Com.Module.Promodule"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	try
	{
		int id = Integer.parseInt(request.getParameter("UserId"));
		out.print(id);
		Promodule P = new Promodule(JdbcConnection.getConnection());
		List<JobApplicationFormEntity> l = P.Checkid(id);
		for(JobApplicationFormEntity ja:l)
		{
	%>
	<main id="main" class="main">
	<section class="section">
      <div class="Container">
      
              <form action="UserInsertServlet" method="post" >
              
              <div class="row">
              <div class="col-md-4">
              <label> User Id </label>
              <input type="text" class="form-control" id="inputText" name="id" value="<%=ja.getJobApplicationId()%>">
              </div>
              
              <div class="col-md-4">
              <label> Job Title </label>
              <input type="text" class="form-control" id="inputText" name="job" value="<%=ja.getJobTitle()%>">
              </div>
              </div>
                <br>
                
               <div class="row">
              <div class="col-md-4">
              <label> User Name </label>
             <input type="text" class="form-control" id="inputText" name="ynm" value="<%=ja.getJobApplicationUserName()%>">
              </div>
              
              <div class="col-md-4">
              <label> User Email </label>
               <input type="text" class="form-control" id="inputText" name="yemail" value="<%=ja.getJobApplicationUserEmail()%>">
              </div>
              </div>
              <br>
              
               <button type="submit" class="btn-center"> Submit </button>
              
                      
         </form><!-- End Horizontal Form -->   
         
         <%	 
        	 }
         }
	catch(Exception e)
	{
		e.printStackTrace();
	}
         %>    
	
</body>
</html>