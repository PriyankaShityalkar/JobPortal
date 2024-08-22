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

import Com.Entity.UserProfileEntity;
import Com.JdbcConnection.JdbcConnection;
import Com.Module.Promodule;

/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet("/UserProfileServlet")
@MultipartConfig(maxFileSize = 999999999)
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileServlet() {
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
		
		String userfirstname = request.getParameter("fnm");
		String userlastname = request.getParameter("lnm");
		String useremail = request.getParameter("email");
		String usermobilenumber = request.getParameter("mobile");
		String usereducation = request.getParameter("edu");
		String userstatus = request.getParameter("ure");
		
		
		Part filePart=request.getPart("file");
		byte[] resumeData = null;
		
		if (filePart != null && filePart.getSize() > 0) {
            try (InputStream inputStream = filePart.getInputStream()) {
                resumeData = inputStream.readAllBytes();  // Convert InputStream to byte array
            }
        }
		
		UserProfileEntity up = new UserProfileEntity();
		up.setUserFirstName(userfirstname);
		up.setUserLastName(userlastname);
		up.setUserEmail(useremail);
		up.setUserMobileNumber(usermobilenumber);
		up.setUserEducation(usereducation);
		up.setUserResume(resumeData);
		up.setUserStatus(userstatus);
		
		try
		{
			Promodule P = new Promodule(JdbcConnection.getConnection());
			boolean f = P.InsertUserProfile(up);
			if(f)
			{
				System.out.println("Record Inserted");
				response.sendRedirect("JobList.jsp");
			}
			else 
			{
                response.getWriter().write("Failed to insert record");
            }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.getWriter().write("Error: " + e.getMessage());
		}	
		
	}

}
