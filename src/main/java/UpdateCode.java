

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCode
 */
@WebServlet("/UpdateCode")
public class UpdateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		{
			response.setContentType("text/html");

			PrintWriter out=response.getWriter();
			String name=request.getParameter("uname");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
			String mobilenumber=request.getParameter("mobilenumber");
			 
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","VINAY","vinay");
				PreparedStatement ps=con.prepareStatement("update register set password=?, email=?, address=?,mobilenumber=? where name=?");
				
				ps.setString(1,password);
				ps.setString(2,email);
				ps.setString(3,address);
				ps.setString(4,mobilenumber);
				
				ps.setString(5, name);
                int i=ps.executeUpdate();
				out.println(i+"Record updated");
			    con.close();
			    }
			    catch(Exception ex)
			    {
				out.print(ex);
			     }
		}
	}
	

	
}
