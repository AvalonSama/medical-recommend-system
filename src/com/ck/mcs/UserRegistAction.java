package com.ck.mcs;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegistAction
 */
@WebServlet("/UserRegistAction")
public class UserRegistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Patient tempp=new Patient();
        tempp.setName(new String(request.getParameter("inputUsername").getBytes("ISO-8859-1"),"UTF-8"));
        tempp.setPwd(request.getParameter("inputPassword"));
        tempp.setEmail(request.getParameter("inputEmail"));
        tempp.setTel(request.getParameter("inputTel"));
        tempp.setAge(Integer.parseInt(request.getParameter("inputAge")));
        String Gender = new String(request.getParameter("selectGender").getBytes("ISO-8859-1"),"UTF-8");
        tempp.setGender(Gender);
        
        SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tempp.setCreateTime(df.format(new Date()));
        DataIssues.Insert("User", tempp);
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
