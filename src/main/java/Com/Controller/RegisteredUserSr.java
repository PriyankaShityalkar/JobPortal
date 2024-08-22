package Com.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.Entity.UserRegistrationEntity;
import Com.JdbcConnection.JdbcConnection;
import Com.Module.Promodule;

/**
 * Servlet implementation class RegisteredUserSr
 */
@WebServlet("/RegisteredUserSr")
public class RegisteredUserSr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisteredUserSr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	

		
		
//		String userId = request.getParameter("userId");
//        String userName = request.getParameter("userName");
//        String userEmail = request.getParameter("userEmail");
//        String userPassword = request.getParameter("userPassword");
//        String userMobileNumber = request.getParameter("userMobileNumber");
//        String userLocation = request.getParameter("userLocation");
//        String userRegistrationFee = request.getParameter("userRegistrationFee");
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal\",\"root\",\"root");
//            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (user_id, user_name, user_email, user_password, user_mobile_number, user_location, user_registration_fee) VALUES (?,?,?,?,?,?,?)");
//            pstmt.setString(1, userId);
//            pstmt.setString(2, userName);
//            pstmt.setString(3, userEmail);
//            pstmt.setString(4, userPassword);
//            pstmt.setString(5, userMobileNumber);
//            pstmt.setString(6, userLocation);
//            pstmt.setString(7, userRegistrationFee);
//            pstmt.executeUpdate();
//            conn.close();
//        } catch (SQLException e) {
//            // Handle the exception
//        } catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		
		String username = request.getParameter("unm");
		System.out.println(username);
		String useremail = request.getParameter("uemail");
		System.out.println(useremail);
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
			boolean f = P.InsertRegisteredUser(ur);
			if(f)
			{
				System.out.println("Record Inserted");
				f = true;
				response.sendRedirect("AddUser.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
		
		
		
		
		
		
		
	}

}
