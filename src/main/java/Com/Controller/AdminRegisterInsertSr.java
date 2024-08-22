package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.Entity.AdminRegisterEntity;
import Com.JdbcConnection.JdbcConnection;
import Com.Module.Promodule;

/**
 * Servlet implementation class AdminRegisterInsertSr
 */
@WebServlet("/AdminRegisterInsertSr")
public class AdminRegisterInsertSr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegisterInsertSr() {
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
		
		String name = request.getParameter("nm");
		String email = request.getParameter("em");
		String username = request.getParameter("usernm");
		String password = request.getParameter("pass");
		
		AdminRegisterEntity ar = new AdminRegisterEntity();
		ar.setAdminName(name);
		ar.setAdminEmail(email);
		ar.setAdminUserName(username);
		ar.setAdminPassword(password);
		
		try
		{
			Promodule P = new Promodule(JdbcConnection.getConnection());
			boolean f = P.insert(ar);
			if(f)
			{
				System.out.println("Record Inserted");
			}
		}
		catch(Exception e)
		{
			
		}
	}

}
