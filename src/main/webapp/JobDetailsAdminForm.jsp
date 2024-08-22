<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="Com.Entity.UserRegistrationEntity"%>
<%@page import="java.util.List"%>
<%@page import="Com.JdbcConnection.JdbcConnection"%>
<%@page import="Com.Module.Promodule"%>
    <%@ include file="Header.jsp" %>
    <%@ include file="LeftNavigationBar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Forms / Layouts - NiceAdmin Bootstrap Template</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: NiceAdmin
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Updated: Apr 20 2024 with Bootstrap v5.3.3
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>
<body>
<main id="main" class="main">
	<section class="section">
	<form action="JobDetailsServlet" method="post" enctype="multipart/form-data">
	
	<div class="row">
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Company Logo </b></label>
		<div class="col-sm-10">
    	   <input type="file" name="img" accept="Image/*">
    	</div>
	</div>
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b>  Job Title  </b></label>
        <div class="col-sm-10">
         <input type="text" class="form-control" id="inputex" name="title">
        </div>
	</div>
	</div>
		
	<div class="row">
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Job Location </b> </label>
		<div class="col-sm-10">
    	   <input type="text" class="form-control" id="inputex" name="location">
    	</div>
	</div>
	
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Job Type </b></label>
        <div class="input-group has-validation">
                        <select class="form-select" id="floatingSelect" name="type">
                      <option selected>Select</option>
                      <option value="Full Time">Full Time</option>
                      <option value="Part Time">Part Time</option>
                    </select>
                    
                      </div>
	</div>
	</div>
    
    <div class="row">
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Job Salary </b> </label>
		<div class="col-sm-10">
    	   <input type="text" class="form-control" id="inputex" name="salary">
    	</div>
	</div>
	
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Job Description </b></label>
        <div class="col-sm-10">
         <input type="text" class="form-control" id="inputex" name="description">
        </div>
	</div>
	</div>
	
	<div class="row">
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Job Responsibility </b></label>
		<div class="col-sm-10">
    	   <input type="text" class="form-control" id="inputex" name="responsibility">
    	</div>
	</div>
	
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Job Qualification </b></label>
        <div class="col-sm-10">
         <input type="text" class="form-control" id="inputex" name="qualification">
        </div>
	</div>
	</div>
	
	<div class="row">
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b>Job Summary </b></label>
		<div class="col-sm-10">
    	   <input type="text" class="form-control" id="inputex" name="summary">
    	</div>
	</div>
	
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b> Job Company Detail </b></label>
        <div class="col-sm-10">
         <input type="text" class="form-control" id="inputex" name="detail">
        </div>
	</div>
	</div> 
	
	<div class="row">
	<div class="col-md-6">
	<label class="col-sm-4 col-form-label"> <b>Job Date Line </b></label>
		<div class="col-sm-10">
    	   <input type="text" class="form-control" id="inputex" name="dateline">
    	</div>
	</div>
	</div>
	
	<div class="row">
	<div class="col-md-6"> 
	<button type="submit"> Submit </button>
	</div>
	</div>    
	</form>
	</section>
	</main>
</body>
</html>