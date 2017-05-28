<%@page import="com.ck.mcs.DataIssues"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Head.jsp"></jsp:include>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<jsp:include page="Sliderbar.jsp"></jsp:include>
	<section id="main-content"> <section class="wrapper">
	<!-- page start-->
	<div class="row">
		<div class="col-lg-12">
			<section class="panel"> <header class="panel-heading">
			问题详情 </header>

			<div class="row">
				<div class="col-lg-10">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h1 class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapseOne">
								<%
								    ResultSet rs;
								    rs = com.ck.mcs.DataIssues.QueryAll("Question");
								    String Qid = request.getParameter("QuestionID");
								    boolean flag = false;
								    while (rs.next()) {
								        if (rs.getInt("QuestionID") == Integer.parseInt(Qid)) {
								            flag = true;
								            break;
								        }
								    }
								%>
								<%=rs.getString("QuestionTitle")%>
							</h1>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in">
							<div class="panel-body">
								<h4>
									<%
									    String text = rs.getString("QuetionText");
									    out.print(text);
									%>
								</h4>
							</div>
						</div>
					</div>
				</div>

			</div>
			<div class="row">
			 <div class="col-lg-6">
                      <section class="panel">
                          <header class="panel-heading">
                              问题回答
                          </header>
                          <div class="panel-body">

                       
                                  <% 
                                  ResultSet answerRs = DataIssues.QueryAll("Answer");
                                  while(answerRs.next()){
                                      if(answerRs.getString("AnswerTo").equals(Qid)){%>
                                      <div class="msg-time-chat">
                                      <a href="#" class="message-img"><img class="avatar" src="img/chat-avatar.jpg" alt=""></a>
                                      <div class="message-body msg-in">
                                          <span class="arrow"></span>
                                          <div class="text">
                                              <p class="attribution"><a href="#"><%=answerRs.getString("AnswerFrom") %></a> at <%=answerRs.getString("AnswerCreateTime")%></p>
                                              <p><%=answerRs.getString("AnswerText") %></p>
                                          </div>
                                      </div>
                                      </div>
                                      <%}
                                  }
                                  %>
                              
                              <form class="form" action="AnswerAction" method="post" charset="uft-8">
                                  <div class="input-cont ">
                                      <textarea class="form-control" cols="60" rows="5" placeholder="添加回答" name="AnswerText" ></textarea>
                                      <input type="hidden" name="QuestionID" value=<%=Qid%>>
                                  </div>
                                  <div class="form-group">
                                      <div class="pull-right chat-features">
                                          <a href="javascript:;">
                                              <i class="icon-camera"></i>
                                          </a>
                                          <a href="javascript:;">
                                              <i class="icon-link"></i>
                                          </a>
                                          <button class="btn btn-danger" href="javascript:;">添加回答</button>
                                      </div>
                                  </div>
                                  
                              </form>
                          </div>
                      </section>
                  </div>
                  
                  </div>

		</div>
	</div>
	</section> <!-- page end--> </section>
	</section>
	<!--main content end-->
	</section>

	<jsp:include page="Script.jsp"></jsp:include>
</body>
</html>