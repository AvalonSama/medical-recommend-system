<%@page import="com.ck.mcs.CF"%>
<%@page import="com.ck.mcs.DataIssues"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.ck.mcs.Question" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Head.jsp"></jsp:include>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<jsp:include page="Sliderbar.jsp"></jsp:include>
	
	<section id="main-content"> <section class="wrapper">
	<div class="row">
		<div class="col-lg-8">
			<section class="panel"> <header class="panel-heading">
			问题咨询<button class="btn btn-space btn-info pull-right" type="button" ><a href="Ask.jsp">我要提问</a></button>
			 </header>
			<table class="table table-striped table-advance table-hover">
				<thead>
					<tr>

						<th><i class="icon-bullhorn"></i> 科室</th>
						<th class="hidden-phone"><i class="icon-question-sign"></i>
							问题</th>
						<th><i class="icon-bookmark"></i> 创建时间</th>
					</tr>
				</thead>
				<tbody>
					<%
					boolean flag = false;
					String QuestionClass = request.getParameter("QuestionClass");
					if(request.getParameter("QuestionClass")==null){
					    flag = true;
					}
					else{
					    flag = false;
					    
					}
					    
					%>
					<%
					if(session.getAttribute("UserName") == null || session.getAttribute("UserRole").toString().compareTo("User")!=0){
                    ResultSet rs;
                    rs=com.ck.mcs.DataIssues.QueryAll("Question");
                    
                    while(rs.next()){
                        if(flag == false){
                            if(QuestionClass.compareTo(rs.getString("QuestionClass"))!=0){
                                continue;
                            }
                        }
                    %>
                    <tr>
                             
						<td><%
						out.print(rs.getString("QuestionClass")); %></td>
						<td><a action="QuestionAction"  href="Answer.jsp?QuestionID=<%=rs.getInt("QuestionID")%>" ><%
						
						out.print(rs.getString("QuestionTitle")); %></a></td>
						<td><%out.print(rs.getString("QuestionCreateTime"));%></td>
					</tr>
					<%
                    }
					}
					else{
					    com.ck.mcs.Patient p = new com.ck.mcs.Patient();
					    String userName = (String)session.getAttribute("UserName");
					    ResultSet tpRs = DataIssues.QueryAll("User");
					    while(tpRs.next()){
					        String tpName = tpRs.getString("UserName");
					        int tpAge = tpRs.getInt("UserAge");
					        String tpGender = tpRs.getString("UserGender");
					        if(tpName.compareTo(userName)==0)
					        {
					            p.setAge(tpAge);
					            p.setGender(tpGender);
					            p.setName(userName);
					            break;
					        }

					    }
					   CF cf = new CF(p);
					   List<Question> ql = cf.Recommend(); 
					   for(Question question : ql){
					       if(flag == false){
	                            if(QuestionClass.compareTo(question.getQuestionClass())!=0){
	                                continue;
	                            }
					       %>
					       <tr>
                            <td><%out.print(question.getQuestionClass()); %></td>
                            <td><a action="QuestionAction"  href="Answer.jsp?QuestionID=<%=question.getQuestionID() %>" ><%
                        
                            out.print(question.getQuestionTitle()); %></a></td>
                            <td><%out.print(question.getQuestionCreateTime());%></td>
                    </tr>
					       <%
					   }
					}
					}
					%>
				</tbody>
			</table>
			</section>
		</div>

		</div>
	</section> </section>

	<jsp:include page="Script.jsp"></jsp:include>
</body>

</html>