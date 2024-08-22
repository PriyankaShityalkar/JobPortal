<%@page import="java.util.ArrayList"%>
<%@page import="Com.Entity.ContactFormEntity"%>
<%@page import="Com.JdbcConnection.JdbcConnection"%>
<%@page import="Com.Module.Promodule"%>
<%@page import="java.util.List"%>
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
<main id="main" class="main">
	<section class="section">
	<table class="table datatable">
                <thead>
                <tr>
                <td> Contact Id </td>
                <td> Contact Person Name </td>
                <td> Contact Person Email </td>
             	<td> Subject Of Contact </td>   
             	<td> Message </td> 
                </tr>
               </thead>
               
               <%
               try
               {
            	   Promodule P = new Promodule(JdbcConnection.getConnection());
            	   List<ContactFormEntity> l = P.allrecords();
            	   for(ContactFormEntity C:l)
            	   {
            	   
               %>
               
               <td> <%=C.getContactId() %> </td>
               <td> <%=C.getContactPersonName() %> </td>
               <td> <%=C.getContactPersonEmail() %> </td>
               <td> <%=C.getSubjectOfContact() %> </td>
               <td> <%=C.getMessage() %> </td>
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
<%@ include file="LeftNavigationBar.jsp" %>
</body>
</html>