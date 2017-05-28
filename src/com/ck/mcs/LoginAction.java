package com.ck.mcs;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String role= request.getParameter("roleradio");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		String username=null;
		boolean result=false;
		HttpSession session = request.getSession();
		if("User".equals(role)){
		    try {
                result=DataIssues.QueryIdentify(email, pwd, role);
                System.out.println(email);
                System.out.println(pwd);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		else if("Doctor".equals(role)){
		    try {
                result=DataIssues.QueryIdentify(email, pwd, role);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		else if("Administrator".equals(role)){
		    try {
                result=DataIssues.QueryIdentify(email, pwd, role);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		System.out.println(result);
		if(result==true){
		    String know=null;
		    String unknow=null;
		    if("User".equals(role)){
		        know="UserEmail";
		        unknow="UserName";
		    }
		    else if("Doctor".equals(role)){
		        know="DoctorEmail";
		        unknow="DoctorName";
		    }
		    username=DataIssues.Query(role, know,email , unknow);
		    System.out.println(unknow);
		    session.setAttribute("UserName", username);
		    session.setAttribute("UserRole", role);
		}
		response.sendRedirect("Index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
