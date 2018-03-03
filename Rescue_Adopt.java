package com.rescue;

import java.io.IOException;
import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Rescue_Adopt
 */
@WebServlet("/Rescue_Adopt")
public class Rescue_Adopt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rescue_Adopt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		String e=request.getParameter("email_id");
		String n=request.getParameter("Number_Of_Dogs");
		String na=request.getParameter("Name_Of_Organization");
		String c=request.getParameter("Contact_Number");
		String r=request.getParameter("Rescue_Adopt");
		
		
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Custom_Trendz?useSSL=false","parul","gupta@12");
			PreparedStatement ps=conn.prepareStatement("insert into Rescue_Adoption (email_id, Number_Of_Dogs, Name_Of_Organization,Contact_Number, Rescue_Adopt) values(?,?,?,?,?)");
			
			ps.setString(1,e);
			ps.setString(2,n);
			ps.setString(3,na);
			ps.setString(4,c);
			ps.setString(5,r);
			
			int i=ps.executeUpdate();
			if(i>0) {
				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Retrieve");
				dispatcher.forward(request, response);
			} else {
				out.println("No data received.");
			}


		      
		}	
			
		
		catch(Exception e2) {
			System.out.println(e2);
		}
		out.close();		
		}
		


	}
