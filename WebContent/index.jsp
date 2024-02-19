<%@ page import="com.dao.ReadDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pojo.EducationPojo" %>
<%@ page import="com.pojo.AchievementPojo" %>
<%@ page import="com.pojo.CoursePojo" %>
<%@ page import="com.pojo.ProjectPojo" %>
<%@ page errorPage="myerrorpage.jsp" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>My Portfolio</title>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/unicons.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">

    <link rel="stylesheet" href="css/tooplate-style.css">
    
  </head>
  <body>





    
    <nav class="navbar navbar-expand-sm navbar-light">
        <div class="container">
            <a class="navbar-brand" href="index.jsp"><i class='uil uil-user'></i> Prajyot More</a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
                <span class="navbar-toggler-icon"></span>
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item">
                        <a href="#project" class="nav-link"><span data-hover="Projects">Projects</span></a>
                    </li>
                    <li class="nav-item">
                        <a href="#achievements and education" class="nav-link"><span data-hover="Achievements">Achievements</span></a>
                    </li>
                    <li class="nav-item">
                        <a href="#achievements and education" class="nav-link"><span data-hover="Education">Education</span></a>
                    </li>
                    <li class="nav-item">
                        <a href="#contact" class="nav-link"><span data-hover="Courses">Courses</span></a>
                    </li>
                    <li class="nav-item">
                        <a href="#contact" class="nav-link"><span data-hover="Contact">Contact</span></a>
                    </li>
                    <li class="nav-item">
                        <a href="adminlogin.jsp" class="nav-link"><span data-hover="Admin-Login">Admin-Login</span></a>
                    </li>
                </ul>

                <ul class="navbar-nav ml-lg-auto">
                    <div class="ml-lg-4">
                      <div class="color-mode d-lg-flex justify-content-center align-items-center">
                        <i class="color-mode-icon"></i>
                        Color mode
                      </div>
                    </div>
                </ul>
            </div>
        </div>
    </nav>

	<%
		String message = (String) session.getAttribute("IndexMsg");
		if(message != null){
	%>
		<h1 style = "text-align: center; color: red"><%= message %></h1>
	<% 
			session.removeAttribute("IndexMsg");
		}
	%>

    
    
    
    
    
    
    
    
    
    
    
    
    <section class="about full-screen d-lg-flex justify-content-center align-items-center" id="about">
        <div class="container">
            <div class="row">
                
                <div class="col-lg-7 col-md-12 col-12 d-flex align-items-center">
                    <div class="about-text">
                        <small class="small-text">Welcome to <span class="mobile-block">my portfolio website!</span></small>
                        <h1 class="animated animated-text">
                            <span class="mr-2">Hey folks, I'm</span>
                                <div class="animated-info">
                                    <span class="animated-item">Prajyot More</span>
                                    <span class="animated-item">a Student</span>
                                    <span class="animated-item">an Engineer</span>
                                </div>
                        </h1>

                        <p>I am a passionate engineer with a strong foundation in Java and a diverse range of skills in Java-based technologies. With a deep-rooted interest in software development, I have developed my expertise in key areas, including Java Database Connectivity, Java Server Pages, Hibernate, Spring Core, Spring JDBC, and Spring MVC.</p>
                        
                        <div class="custom-btn-group mt-4">
                          <a href="files/Resume.pdf" download='Resume' target="_blank" class="btn mr-lg-2 custom-btn"><i class='uil uil-file-alt'></i> Download Resume</a>
                          <a href="#contact" class="btn custom-btn custom-btn-bg custom-btn-link">Contact me</a>
                        </div>
                    </div>
                </div>

                <div class="col-lg-5 col-md-12 col-12">
                    <div class="about-image svg">
                        <img src="images/undraw/indeximage.svg" class="img-fluid" alt="svg image">
                    </div>
                </div>
            </div>
        </div>
    </section>

    
    
    
    
    
    
    
    
    
    
    <section class="project py-5" id="project">
        <div class="container">
                
                <div class="row">
                  <div class="col-lg-11 text-center mx-auto col-12">

                      <div class="col-lg-8 mx-auto">
                        <h2>Projects I have worked on</h2>
                      </div>

                      <div class="owl-carousel owl-theme">
                        
                        <%
                        	ArrayList<ProjectPojo> al = new ReadDaoImpl().readProject();
                        	for(ProjectPojo pp : al){
                        %>
                        
                        <div class="item">
                          <div class="project-info">
                            <img src="images/project/<%= pp.getFilename() %>" class="img-fluid" alt="project image">
                          </div>
                        </div>

						<%
                        	}
						%>
                        
                      </div>

                  </div>
                </div>
        </div>
    </section>

    
    
    
    
    
    
    
    <section class=" py-5 d-lg-flex justify-content-center align-items-center" id="achievements and education">
        <div class="container">
            <div class="row">

                <div class="col-lg-6 col-12">
                  <h2 style="color:#ffc200;" class="mb-4">Achievements</h2>

                    <div class="timeline">
                    
                      <%
			  		  	  ArrayList<AchievementPojo> ap = new ReadDaoImpl().readAchievement();
			  			  for(AchievementPojo a : ap){
	  				  %>
                        <div class="timeline-wrapper">
                             <div class="timeline-yr">
                                  <span><%= a.getYear()%></span>
                             </div>
                             <div class="timeline-info">
                                  <h3><span><%= a.getTitle()%></span></h3>
                                  <p><%= a.getDescription()%></p>
                             </div>
                        </div>

						<%
			  			    }
                      	%>
                    </div>
                </div>


                <div class="col-lg-6 col-12">
                  <h2 style="color:#ffc200;" class="mb-4 mobile-mt-2">Education</h2>
                  

                    <div class="timeline">
	                  <%
			  		  	  ArrayList<EducationPojo> ep = new ReadDaoImpl().readEducation();
			  			  for(EducationPojo e : ep){
	  				  %>
                        <div class="timeline-wrapper">
                             <div class="timeline-yr">
                                  <span><%= e.getYear()%></span>
                             </div>
                             <div class="timeline-info">
                                  <h3><span><%= e.getLevel()%></span><small style="color: blue;"><%= e.getScore()%></small></h3>
                                  <p><%= e.getDescription()%></p>
                             </div>
                        </div>
                        
                      <%
			  			  }
                      %>
					</div>
                </div>
                
            </div>
        </div>
    </section>

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    <section class="contact py-5" id="contact">
      
      <div class="container">
            <div class="row">

                <div class="col-lg-6 col-12">
                  <h2 style="color:#ffc200;" class="mb-4">Courses</h2>

                    <div class="timeline">
                    
                      <%
			  		  	  ArrayList<CoursePojo> cp = new ReadDaoImpl().readCourse();
			  			  for(CoursePojo c : cp){
	  				  %>
                        <div class="timeline-wrapper">
                             <div class="timeline-yr">
                                  <span><%= c.getId()%></span>
                             </div>
                             <div class="timeline-info">
                                  <h3><span><%= c.getName()%></span></h3>
                                  <p><%= c.getDescription()%></p>
                             </div>
                        </div>

						<%
			  			    }
                      	%>
                    </div>
                </div>


                <div class="col-lg-6 col-12">
              <h2 class="mb-4">Want to send a message? <br> Type here</h2>
            <div style="display: flex; justify-content: center; align-items: center; height: 100vh;" class="contact-form">

              <form action="MyController" method="post">
                <div class="row">
                  <div class="col-lg-6 col-12">
                    <input type="text" class="form-control" name="name" placeholder="Your Name" id="name">
                  </div>

                  <div class="col-lg-6 col-12">
                    <input type="email" class="form-control" name="email" placeholder="Email" id="email">
                  </div>

                  <div class="col-12">
                    <textarea name="description" rows="6" class="form-control" id="description" placeholder="Message"></textarea>
                  </div>

                  <div class="ml-lg-auto col-lg-5 col-12">
                  	<input type="hidden" name="check" value="message">
                    <input type="submit" class="form-control submit-btn" value="Send Button">
                  </div>
                </div>
              </form>
            </div>
          </div>
                
            </div>
        </div>
    </section>

    
    
    
    
    
    
    
    
    
    
    
    
    
    
     <footer class="footer py-5">
          <div class="container">
               <div class="row">

                    <div class="col-lg-12 col-12">                                
                        <p class="copyright-text text-center">Designed by <a href="index.jsp">Prajyot More</a></p>
                    </div>
                    
               </div>
          </div>
     </footer>

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/Headroom.js"></script>
    <script src="js/jQuery.headroom.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/smoothscroll.js"></script>
    <script src="js/custom.js"></script>

  </body>
</html>