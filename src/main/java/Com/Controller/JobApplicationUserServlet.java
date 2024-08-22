package Com.Controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Com.Entity.JobApplicationFormEntity;
import Com.JdbcConnection.JdbcConnection;
import Com.Module.Promodule;

/**
 * Servlet implementation class JobApplicationUserServlet
 */
@WebServlet("/JobApplicationUserServlet")
public class JobApplicationUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobApplicationUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String jobtitle = request.getParameter("job");
		String jobapplicationusername = request.getParameter("ynm");
		String jobapplicationuseremail = request.getParameter("yemail");
		String jobapplicationusercontact = request.getParameter("ycontact");
		String usereducation = request.getParameter("ueducation");
		String jobapplicationuserresume = request.getParameter("yresume");
		String jobapplicationuserareaofexpertise = request.getParameter("expertise");
		
		JobApplicationFormEntity ja = new JobApplicationFormEntity();
		ja.setJobTitle(jobtitle);
		ja.setJobApplicationUserName(jobapplicationusername);
		ja.setJobApplicationUserEmail(jobapplicationuseremail);
		ja.setJobApplicationUserContact(jobapplicationusercontact);
		ja.setUserEducation(usereducation);
		ja.setJobApplicationUserResume(jobapplicationuserresume);
		ja.setJobApplicationUserAreaOfExpertise(jobapplicationuserareaofexpertise);
		
		try
		{
			Promodule P = new Promodule(JdbcConnection.getConnection());
			boolean f = P.InsertApplicationForm(ja);
			if(f)
			{
				System.out.println("Record Inserted");
				response.sendRedirect("Index.jsp");
			}
			else {
                response.getWriter().write("Failed to insert record.");
            }
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
            response.getWriter().write("Error: " + e.getMessage());

		}
	}

}
