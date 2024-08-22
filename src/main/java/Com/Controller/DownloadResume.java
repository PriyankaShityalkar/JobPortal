package Com.Controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.JdbcConnection.JdbcConnection;
import Com.Module.Promodule;

/**
 * Servlet implementation class DownloadResume
 */
@WebServlet("/DownloadResume")
public class DownloadResume extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadResume() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String userId = request.getParameter("UserId");

        try  {
        	Class.forName("com.mysql.jdbc.Driver");
	Connection	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal","root","root");	
            String sql = "SELECT JobApplicationUserResume FROM jobapplication WHERE JobApplicationId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                byte[] resumeData = rs.getBytes("JobApplicationUserResume");

                // Set the response headers
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition", "attachment;filename=resume_" + userId + ".pdf");

                // Write the resume data to the response
                OutputStream out = response.getOutputStream();
                out.write(resumeData);
                out.flush();
            } else {
                // Handle case where resume is not found
                response.getWriter().println("Resume not found for User ID: " + userId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
