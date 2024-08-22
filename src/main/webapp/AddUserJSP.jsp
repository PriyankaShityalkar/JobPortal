<%@page import="Com.Entity.UserRegistrationEntity"%>
<%@page import="java.util.List"%>
<%@page import="Com.JdbcConnection.JdbcConnection"%>
<%@page import="Com.Module.Promodule"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="Header.jsp" %>
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
	int id=Integer.parseInt(request.getParameter("UserId"));
	out.print(id);
	Promodule P = new Promodule(JdbcConnection.getConnection());
	List<UserRegistrationEntity> l = P.CheckId(id);
	for(UserRegistrationEntity ur:l)
	{
	
	%>
<main id="main" class="main">
	<section class="section">
      <div class="Container">
      
              <form action="RegisteredUserSr" method="post" >
              
              <div class="row">
              <div class="col-md-4">
              <label> User Id </label>
              <input type="text" class="form-control" id="inputText" name="id" value="<%=ur.getUserId()%>">
              </div>
              
              <div class="col-md-4">
              <label> User Name </label>
              <input type="text" class="form-control" id="inputText" name="unm" value="<%=ur.getUserName()%>">
              </div>
              </div>
                <br>
                
               <div class="row">
              <div class="col-md-4">
              <label> User Email </label>
             <input type="text" class="form-control" id="inputText" name="uemail" value="<%=ur.getUserEmail()%>">
              </div>
              
              <div class="col-md-4">
              <label> User Password </label>
               <input type="text" class="form-control" id="inputText" name="upass" value="<%=ur.getUserPassword()%>">
              </div>
              </div>
              <br>
              
               <div class="row">
              <div class="col-md-4">
              <label> User Mobile Number </label>
			<input type="text" class="form-control" id="inputText" name="umo" value="<%=ur.getUserMobileNumber()%>">
              </div>
              
              <div class="col-md-4">
              <label> User Location </label>
                    <input type="text" class="form-control" id="inputText" name="ulo" value="<%=ur.getUserLocation()%>">
              </div>
              </div>
				<br>
				
				<div class="row">
              <div class="col-md-4">
              <label> User Registration Fee </label>
                    <input type="text" class="form-control" id="inputText" name="ure" value="<%=ur.getUserRegistrationFee()%>">
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
        
          
    </section>

  </main><!-- End #main -->
 
</body>
</html>