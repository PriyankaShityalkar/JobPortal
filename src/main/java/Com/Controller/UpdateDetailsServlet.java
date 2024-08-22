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

import Com.Entity.JobDetailsEntity;
import Com.JdbcConnection.JdbcConnection;
import Com.Module.Promodule;

/**
 * Servlet implementation class UpdateDetailsServlet
 */
@WebServlet("/UpdateDetailsServlet")
@MultipartConfig(maxFileSize = 999999999)
public class UpdateDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDetailsServlet() {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		
		InputStream inputStream = null;
		Part filePart = request.getPart("img");
		if(filePart!= null)
		{
			inputStream = filePart.getInputStream();
		}
		
		String jobtitle = request.getParameter("title");
		String joblocation = request.getParameter("location");
		String jobtype = request.getParameter("type");
		String jobsalary = request.getParameter("salary");
		String jobdescription = request.getParameter("description");
		String jobresponsibility = request.getParameter("responsibility");
		String jobqualification = request.getParameter("qualification");
		String jobsummary = request.getParameter("summary");
		String jobcompanydetail = request.getParameter("detail");
		String jobdateline = request.getParameter("dateline");
		
		JobDetailsEntity jd = new JobDetailsEntity();
		jd.setJobId(id);
		
		byte[] im = new byte [inputStream.available()];
		inputStream.read(im);
		jd.setCompanyLogo(im);
		
		jd.setJobTitle(jobtitle);
		jd.setJobLocation(joblocation);
		jd.setJobType(jobtype);
		jd.setJobSalary(jobsalary);
		jd.setJobDescription(jobdescription);
		jd.setJobResponsibility(jobresponsibility);
		jd.setJobQualification(jobqualification);
		jd.setJobSummary(jobsummary);
		jd.setJobCompanyDetail(jobcompanydetail);
		jd.setJobDateLine(jobdateline);
		
		try
		{
			Promodule P = new Promodule(JdbcConnection.getConnection());
			boolean f = P.update(jd);
			if(f)
			{
				response.sendRedirect("AdminJobList.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
