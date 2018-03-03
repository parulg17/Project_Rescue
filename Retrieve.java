package com.rescue;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Retrieve
 */
@WebServlet("/Retrieve")
public class Retrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Retrieve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();       
		 String c=req.getParameter("Rescue_Adopt");	
		 String client=req.getParameter("Name_Of_Organization");

		
		    try{
		    	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		    	//Class.forName("com.mysql.jdbc.Driver");  
		    	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Custom_Trendz?useSSL=false","parul","gupta@12");
		    	  PreparedStatement ps=con.prepareStatement("Select Contact_Num,Name_Of_Client from Client_Det where Name_Of_Organization=? and Rescue_Adopt=?");
		    	  	ps.setString(1 ,client);
		    	     ps.setString(2, c);
		    	     
		    	    
		    	 
		    	     out.print("<html><body bgcolor='grey'>");
		    	     
		        out.print("<table width=100% border=1>");

		     out.print("<center>");
		    	
		        out.print(" <tr><th> Contact number </th> ");
		        out.print(" <th> Name Of Client </th> ");
		       out.print("</tr>");
		        
		        out.print("</center>");
	out.print("</body></html>");
		        ResultSet rs=ps.executeQuery();                

		        /* Printing column names */

		        

		        while(rs.next())

		           {

		        out.print("<tr>");
		        
		        
		           out.print("<td>"+rs.getString(1)+"</td>");
		           out.print("<td>"+rs.getString(2)+"</td>");
		      
		           
		        }

		        out.print("</table>");
		      


		 }catch (Exception e2)

		   {

		       e2.printStackTrace();

		   }



		 finally{out.close();}
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	