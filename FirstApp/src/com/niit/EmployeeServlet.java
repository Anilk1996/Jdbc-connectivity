package com.niit;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/s1")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
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
		String driver="org.h2.Driver";
		//String url="jdbc:h2:~/test";
		String username="sa";
		String password="";
		String name=request.getParameter("t1");
		
		PreparedStatement pstmt;
		
		try {
			Connection con=null;
			Class.forName(driver);
			con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test",username,password);
			System.out.println(name);
		
		if(con!=null)
			System.out.println("connection is successful");
		
		else
			System.out.println("connection not successful");
		
			pstmt=con.prepareStatement("insert into employee values(?)");
			pstmt.setString(1,name);
			int rowStatus=pstmt.executeUpdate();
			if(rowStatus>0) 
				System.out.println("Row Inserted");
			else
				System.out.println("Insertion error");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
