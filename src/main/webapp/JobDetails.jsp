<%@page import="java.util.Base64"%>
<%@page import="Com.Entity.JobDetailsEntity"%>
<%@page import="java.util.List"%>
<%@page import="Com.JdbcConnection.JdbcConnection"%>
<%@page import="Com.Module.Promodule"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="UserHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JobEntry - Job Portal Website Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Inter:wght@700;800&display=swap" rel="stylesheet">
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<div class="container-xxl bg-white p-0">
<!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->
        
        <!-- Carousel Start -->
        <div class="container-fluid p-0">
            <div class="owl-carousel header-carousel position-relative">
                <div class="owl-carousel-item position-relative">
                    <img class="img-fluid" src="img/carousel-1.jpg" alt="">
                    <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center" style="background: rgba(43, 57, 64, .5);">
                        <div class="container">
                            <div class="row justify-content-start">
                                <div class="col-10 col-lg-8">
                                    <h1 class="display-3 text-white animated slideInDown mb-4">Find The Perfect Job That You Deserved</h1>
                                    <p class="fs-5 fw-medium text-white mb-4 pb-2">Vero elitr justo clita lorem. Ipsum dolor at sed stet sit diam no. Kasd rebum ipsum et diam justo clita et kasd rebum sea elitr.</p>
                                    <a href="" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft">Search A Job</a>
                                    <a href="" class="btn btn-secondary py-md-3 px-md-5 animated slideInRight">Find A Talent</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="owl-carousel-item position-relative">
                    <img class="img-fluid" src="img/carousel-2.jpg" alt="">
                    <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center" style="background: rgba(43, 57, 64, .5);">
                        <div class="container">
                            <div class="row justify-content-start">
                                <div class="col-10 col-lg-8">
                                    <h1 class="display-3 text-white animated slideInDown mb-4">Find The Best Startup Job That Fit You</h1>
                                    <p class="fs-5 fw-medium text-white mb-4 pb-2">Vero elitr justo clita lorem. Ipsum dolor at sed stet sit diam no. Kasd rebum ipsum et diam justo clita et kasd rebum sea elitr.</p>
                                    <a href="" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft">Search A Job</a>
                                    <a href="" class="btn btn-secondary py-md-3 px-md-5 animated slideInRight">Find A Talent</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Job Detail Start -->
     
        <%
        
        try
        {
        	int id = Integer.parseInt(request.getParameter("JobId"));
        	System.out.print(id);
        	Promodule P = new Promodule(JdbcConnection.getConnection());
        	List<JobDetailsEntity> l = P.checkId(id);
        	for(JobDetailsEntity jd:l)
        	{
        %>
        
        <div class="container-xxl py-5 wow fadeInUp" data-wow-delay="0.1s">
            <div class="container">
            <form action="JobApplicationUserServlet" method="post" enctype="multipart/form-data">
                <div class="row gy-5 gx-4">
                
                    <div class="col-lg-8">
                    
                        <div class="d-flex align-items-center mb-5">
                            <img class="flex-shrink-0 img-fluid border rounded" src="data:image/jpeg;base64,<%=Base64.getEncoder().encodeToString(jd.getCompanyLogo())%>" alt="" style="width: 80px; height: 80px;">
                            <div class="text-start ps-4">
                             <%-- <h3 class="mb-3 hidden"> <%=jd.getJobId() %> </h3> --%>
                               <h3 class="mb-3"> <%=jd.getJobTitle() %> </h3> 
                                <span class="text-truncate me-3"><i class="fa fa-map-marker-alt text-primary me-2"></i> <%=jd.getJobLocation() %> </span>
                                <span class="text-truncate me-3"><i class="far fa-clock text-primary me-2"></i> <%=jd.getJobType() %> </span>
                                <span class="text-truncate me-0"><i class="far fa-money-bill-alt text-primary me-2"></i> <%=jd.getJobSalary() %> </span>
                            </div>
                        </div>

                        <div class="mb-5">
                            <h4 class="mb-3">Job description</h4>
                            <p> <%=jd.getJobDescription() %> </p>
                            <h4 class="mb-3">Responsibility</h4>
                            <p> <%=jd.getJobResponsibility() %> </p>
                           <%-- <ul class="list-unstyled">
                                <li><i class="fa fa-angle-right text-primary me-2"></i>Dolor justo tempor duo ipsum accusam</li>
                                <li><i class="fa fa-angle-right text-primary me-2"></i>Elitr stet dolor vero clita labore gubergren</li>
                                <li><i class="fa fa-angle-right text-primary me-2"></i>Rebum vero dolores dolores elitr</li>
                                <li><i class="fa fa-angle-right text-primary me-2"></i>Est voluptua et sanctus at sanctus erat</li>
                                <li><i class="fa fa-angle-right text-primary me-2"></i>Diam diam stet erat no est est</li>
                            </ul>
                            --%>
                            <h4 class="mb-3">Qualifications</h4>
                            <p> <%=jd.getJobQualification() %> </p>
                           <%--<ul class="list-unstyled">
                                <li><i class="fa fa-angle-right text-primary me-2"></i>Dolor justo tempor duo ipsum accusam</li>
                                <li><i class="fa fa-angle-right text-primary me-2"></i>Elitr stet dolor vero clita labore gubergren</li>
                                <li><i class="fa fa-angle-right text-primary me-2"></i>Rebum vero dolores dolores elitr</li>
                                <li><i class="fa fa-angle-right text-primary me-2"></i>Est voluptua et sanctus at sanctus erat</li>
                                <li><i class="fa fa-angle-right text-primary me-2"></i>Diam diam stet erat no est est</li>
                            </ul>
                            --%>
                        </div>
       
                        <div class="">
                            <h4 class="mb-4">Apply For The Job</h4>
                            
                                <div class="row g-3">
                                <div class="col-12 col-sm-6">
                                    <label> <b> Job Title </b>  </label>
                                        <input type="text" class="form-control" name="job" value=" <%=jd.getJobTitle() %>" readonly="readonly" >
                                      
                                    </div>
                                    <div class="col-12 col-sm-6">
                                    <label> <b> Your Name </b>  </label>
                                        <input type="text" class="form-control" name="ynm" placeholder="Enter Your Name">
                                    </div>
                                    <div class="col-12 col-sm-6">
                                    <label> <b>Your Email </b> </label>
                                        <input type="email" class="form-control" name="yemail" placeholder="Enter Your Email">
                                    </div>
                                    <div class="col-12 col-sm-6">
                                    <label> <b> Your Contact Number </b> </label>
                                        <input type="text" class="form-control" name="ycontact" maxlength="10" placeholder="Enter Your Contact">
                                    </div>
                                    
                                    
                  
                  <div class="col-12 col-sm-6">
                  <label> <b> Select Education </b> </label>
                    <select class="form-select" aria-label="Default select example" name="ueducation">
                      <option selected>Select</option>
                      <option value="BE">BE</option>
                      <option value="B.Tech">B.Tech</option>
                      <option value="BCA">BCA</option>
                      <option value="MSC">MSC</option>
                      <option value="MCA">MCA</option>
                      <option value="BSC">BSC</option>
                      <option value="M.Tech">M.Tech</option>
                    </select>
                  </div>
               
                                    
                                    <div class="col-12 col-sm-6">
                                    <label> <b> Select Your Resume </b> </label>
                                        <input type="file" name="yresume" class="form-control bg-white">
                                    </div>
                                    <div class="col-12">
                                    <label> <b> Area Of Expertise </b> </label>
                                        <textarea class="form-control" rows="5" name="expertise" placeholder="Enter Your Expertise"></textarea>
                                    </div>
                                    <div class="col-12">
                                        <button class="btn btn-primary w-100" type="submit">Apply Now</button>
                                    </div>
                                </div>
                            
                        </div>
                    </div>
        
                    <div class="col-lg-4">
                        <div class="bg-light rounded p-5 mb-4 wow slideInUp" data-wow-delay="0.1s">
                            <h4 class="mb-4">Job Summary</h4>
                            <p> <%=jd.getJobSummary() %> </p>
                            <%--
                            <p><i class="fa fa-angle-right text-primary me-2"></i>Published On: 01 Jan, 2045</p>
                            <p><i class="fa fa-angle-right text-primary me-2"></i>Vacancy: 123 Position</p>
                            <p><i class="fa fa-angle-right text-primary me-2"></i>Job Nature: Full Time</p>
                            <p><i class="fa fa-angle-right text-primary me-2"></i>Salary: $123 - $456</p>
                            <p><i class="fa fa-angle-right text-primary me-2"></i>Location: New York, USA</p>
                            <p class="m-0"><i class="fa fa-angle-right text-primary me-2"></i>Date Line: 01 Jan, 2045</p>
                            --%>
                        </div>
                        <div class="bg-light rounded p-5 wow slideInUp" data-wow-delay="0.1s">
                            <h4 class="mb-4">Company Detail</h4>
                            <p class="m-0"> <%=jd.getJobCompanyDetail() %> </p>
                        </div>
                    </div>
                </div>
                </form>
            </div>
        </div>
          <%
		}
	}
	catch(Exception E)
	{
		E.printStackTrace();
	}
	%>
        <!-- Job Detail End -->
      </div>  
<%@ include file="UserFooter.jsp" %>
</body>
</html>