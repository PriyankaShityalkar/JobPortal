package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.Entity.ContactFormEntity;
import Com.JdbcConnection.JdbcConnection;
import Com.Module.Promodule;

/**
 * Servlet implementation class ContactFormServlet
 */
@WebServlet("/ContactFormServlet")
public class ContactFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactFormServlet() {
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
		
		String personname = request.getParameter("name");
		String personemail = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("msg");
		
		ContactFormEntity c = new ContactFormEntity();
		c.setContactPersonName(personname);
		c.setContactPersonEmail(personemail);
		c.setSubjectOfContact(subject);
		c.setMessage(message);
		
		try
		{
		Promodule P = new Promodule(JdbcConnection.getConnection());
		boolean f = P.InsertContactForm(c);
		if(f)
		{
			System.out.println("Record Inserted");
			response.sendRedirect("Index.jsp");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
