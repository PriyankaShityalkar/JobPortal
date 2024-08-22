package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.group.Response;

import Com.JdbcConnection.JdbcConnection;
import Com.Module.Promodule;

/**
 * Servlet implementation class RejectApplicationSer
 */
@WebServlet("/RejectApplicationSer")
public class RejectApplicationSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RejectApplicationSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		int id = Integer.parseInt(request.getParameter("Id"));
		System.out.println(id);
		
		try
		{
			Promodule P = new Promodule(JdbcConnection.getConnection());
			boolean f = P.DelteRecord(id);
			if(f)
			{
				response.sendRedirect("UserAppliedJobAdminPage.jsp");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
