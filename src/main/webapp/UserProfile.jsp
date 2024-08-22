<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="UserHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
        
	<div class="container-xxl py-5 wow fadeInUp" data-wow-delay="0.1s">
            <div class="container" align="center">
                <div class="row gy-5 gx-4">
                    <div class="col-lg-8">
                        <div class="">
                            <h4 class="mb-4">Create Profile </h4>
                            <form action="UserProfileServlet" method="post" enctype="multipart/form-data">
							<div class="row g-3">
                                    <div class="col-12 col-sm-6">
                                        <input type="text" class="form-control" name="fnm" placeholder="Enter First Name">
                                    </div>
                                    
                                    <div class="col-12 col-sm-6">
                                        <input type="text" class="form-control" name="lnm" placeholder="Enter Last Name">
                                    </div>
                                    </div>
                                    <br>
                                    <div class="row g-3">
                                    <div class="col-12 col-sm-6">
                                        <input type="email" class="form-control" name="email" placeholder="Enter Email">
                                    </div>
                                    
                                    <div class="col-12 col-sm-6">
                                        <input type="text" class="form-control"  maxlength="10" name="mobile" placeholder="Enter Mobile Number">
                                    </div>
                                    </div>
                                    
                                    <br>
                                    <div class="row g-3">
                                    <div class="col-12 col-sm-6">
                                        <input type="text" class="form-control" name="edu" placeholder="Enter Education">
                                    </div>
                                    
                                    <div class="col-12 col-sm-6">
                    <select class="form-select" id="floatingSelect" name="ure" aria-label="Select Status">
                      <option selected>Select Status</option>
                      <option value="Fresher">Fresher</option>
                      <option value="Experienced">Experienced</option>
                    </select>
                  </div>
                </div>
                <br>
                <div class="row g-3">
                  <div class="col-12 col-sm-6">
                 
                    <input type="file" name="file" accept="file/*" > 
                  </div>
                  
                  <div class="col-12 col-sm-6">
                  
                   <button type="submit" onclick="msg()"> Submit </button>
                  </div>
                </div>
	</form>
</div>
</div>
</div>
</div>
</div>
</div>
<%@ include file="UserFooter.jsp" %>
<script type="text/javascript">
	function msg()
	{
		alert("Profile Created Successfully");
	}
	
	</script>
</body>
</html>