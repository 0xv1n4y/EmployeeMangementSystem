import java.sql.*;
import java.io.*;

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



@WebServlet("/RegisterCode")
public class RegisterCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			response.setContentType("text/html");

			PrintWriter out=response.getWriter();
			String name=request.getParameter("uname");
			String password=request.getParameter("psw");
			String email=request.getParameter("mail");
			String gender=request.getParameter("gender");
			String mobilenumber=request.getParameter("mobilenumber");
			String state=request.getParameter("state");
			String country=request.getParameter("country");
			String address=request.getParameter("address");
			
			
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","VINAY","vinay");
				PreparedStatement ps=con.prepareStatement("insert into Register values(?,?,?,?,?,?,?,?)");
				
				
				ps.setString(1,name);
				ps.setString(2,password);
				ps.setString(3,email);
				ps.setString(4,gender);
				ps.setString(5,mobilenumber);
				ps.setString(6,state);
				ps.setString(7,country);
				ps.setString(8,address);
				
				int i=ps.executeUpdate();
				
				
				
				out.println(i+"New Record Inserted Sucessfully......");
			con.close();
			}
			catch(Exception ex)
			{
				out.println(ex);
				
			}
			
			
			
		}
	}

	}
