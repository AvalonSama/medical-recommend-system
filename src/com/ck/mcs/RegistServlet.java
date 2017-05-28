package com.ck.mcs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.lang.*;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    response.setCharacterEncoding("UTF-8");
	    response.setHeader("content-type","text/html;charset=UTF-8");
		Doctors tempd=new Doctors();
		tempd.setName(new String(request.getParameter("inputUsername").getBytes("ISO-8859-1"),"UTF-8"));
		tempd.setPwd(request.getParameter("inputPassword"));
		tempd.setEmail(request.getParameter("inputEmail"));
		tempd.setTel(request.getParameter("inputTel"));
		tempd.setHospital(new String(request.getParameter("inputHospital").getBytes("ISO-8859-1"),"UTF-8"));
		tempd.setClass(new String(request.getParameter("selectClass").getBytes("ISO-8859-1"), "UTF-8"));
		tempd.setGrade(new String( request.getParameter("selectGrade").getBytes("ISO-8859-1"), "UTF-8"));
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		tempd.setCreateTime(df.format(new Date()));
		tempd.setACTimes(0);
		tempd.setPicture(null);
		tempd.setIntroduction(new String(request.getParameter("textIntroduction").getBytes("ISO-8859-1"),"UTF-8"));
		response.sendRedirect("Index.jsp");
		System.out.println(DataIssues.Insert("Doctor", tempd));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
