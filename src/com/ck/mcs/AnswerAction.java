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
 * Servlet implementation class AnswerAction
 */
@WebServlet("/AnswerAction")
public class AnswerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    Answer tempA = new Answer();
	    
	    HttpSession session = request.getSession();
	    int ID =Integer.parseInt(request.getParameter("QuestionID"));
	    String AnswerFrom = (String) session.getAttribute("UserName");
	    SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String AnswerCreateTime = df.format(new Date());
	    String AnswerText =new String(request.getParameter("AnswerText").getBytes("ISO-8859-1"),"UTF-8");
	    tempA.setAnswerCreateTime(AnswerCreateTime);
	    tempA.setAnswerFrom(AnswerFrom);
	    tempA.setAnswerTo(ID);
	    tempA.setAnswerText(AnswerText);
	    DataIssues.Insert("Answer", tempA);
	    response.sendRedirect(request.getHeader("Referer"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
