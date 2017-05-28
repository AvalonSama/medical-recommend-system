package com.ck.mcs;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AskAction
 */
@WebServlet("/AskAction")
public class AskAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Question temp=new Question();
		String questionTitle=request.getParameter("QuestionTitle");
		String questionClass = request.getParameter("SelectClass");
		String questionText = request.getParameter("QuestionText");
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String questionCreateTime=df.format(new Date());
		HttpSession session=request.getSession();
		String questionFrom=(String) session.getAttribute("UserName");
		
		temp.setQuestionTitle(questionTitle);
		temp.setQuestionClass(questionClass);
		temp.setQuestionText(questionText);
		temp.setQuestionCreateTime(questionCreateTime);
		temp.setQuestionFrom(questionFrom);
		boolean result=false;
		result=DataIssues.Insert("Question", temp);
		System.out.println(result);
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
