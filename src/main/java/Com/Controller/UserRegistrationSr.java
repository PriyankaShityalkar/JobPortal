package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.Entity.UserRegistrationEntity;
import Com.JdbcConnection.JdbcConnection;
import Com.Module.Promodule;

/**
 * Servlet implementation class UserRegistrationSr
 */
@WebServlet("/UserRegistrationSr")
public class UserRegistrationSr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationSr() {
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
		
		
		
		String username = request.getParameter("unm");
		String useremail = request.getParameter("uemail");
		String userpassword = request.getParameter("upass");
		String usermobilenumber = request.getParameter("umo");
		String userlocation = request.getParameter("ulo");
		String userregistrationfee = request.getParameter("ure");
		
		UserRegistrationEntity ur = new UserRegistrationEntity();
		ur.setUserName(username);
		ur.setUserEmail(useremail);
		ur.setUserPassword(userpassword);
		ur.setUserMobileNumber(usermobilenumber);
		ur.setUserLocation(userlocation);
		ur.setUserRegistrationFee(userregistrationfee);
		
		try
		{
			Promodule P = new Promodule(JdbcConnection.getConnection());
			boolean f = P.InsertUser(ur);
			if(f)
			{
				response.sendRedirect("UserLogin.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

}
