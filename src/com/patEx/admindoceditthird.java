package com.patEx;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class admindoceditthird
 */
@WebServlet("/admindoceditthird")
public class admindoceditthird extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admindoceditthird() {
        super();
        // TODO Auto-generated constructor stub
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		
		admin p2=new admin();
		HttpSession session=request.getSession(false);
		p2=(admin)session.getAttribute("object");
		String x=(String)session.getAttribute("doc");
		
		String a=request.getParameter("fn");
		String b=request.getParameter("ln");
		String c=request.getParameter("email");
		//java.sql.Date c=java.sql.Date.valueOf(c1);
		String d=request.getParameter("ph");
		String e1=request.getParameter("dob");
		java.sql.Date e=java.sql.Date.valueOf(e1);
		//System.out.println("Yes"+a+b+c+d+e+x);
		Connection conn=connection.getconnect();
		String sql = 
				   "UPDATE docinfo " + 
				   "SET fname = ?, lname = ?, emailid = ?, phno = ?,  dob = ? WHERE username =?";
		try {
			PreparedStatement updateQuery  = conn.prepareStatement(sql);
			updateQuery.setString(1, a);
			updateQuery.setString(2, b);
			updateQuery.setString(3, c);
			updateQuery.setString(4, d);
			updateQuery.setDate(5, e);
			updateQuery.setString(6, x);
			updateQuery.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher("/admdash.jsp");
	        rd.forward(request, response);
			
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	
	}
}