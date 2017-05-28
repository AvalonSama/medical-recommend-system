<%@page import="java.sql.ResultSet"%>
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
					<tr>
					                   <%
                    ResultSet rs;
                    rs=com.ck.mcs.DataIssues.QueryAll("Question");
                    
                    while(rs.next()){
                    %>
                        
						<td><%out.print(rs.getString("QuestionClass")); %></td>
						<td><a action="AnswerAction" href="#" ><%
						
						out.print(rs.getString("QuestionTitle")); %></a></td>
						<td><%out.print(rs.getString("QuestionCreateTime"));%></td>
					</tr>
					<%
                    }
					%>
				</tbody>
			</table>
			</section>
		</div>
		<div class="col-lg-1"></div>
		<div class="col-lg-3">
			<!--widget start-->
			<section class="panel">
			<div class="twt-feed blue-bg">
				<h1>李医生</h1>
				<a href="#"> <img src="img/doctor1.jpg" alt="">
				</a>
			</div>
			<div class="weather-category twt-category">
				<ul>
					<li class="active">
						<h5>泌尿外科</h5> 科室
					</li>
					<li>
						<h5>副主任医师</h5> 职称
					</li>
					<li>
						<h5>4.85</h5> 评分
					</li>
				</ul>
			</div>
			<footer class="twt-footer">
			<button class="btn btn-space btn-white" data-toggle="button">
                查看详情</button>
			<button class="btn btn-space btn-info pull-right" type="button">
				<i class="icon-twitter"></i> 向他提问
			</button>
			</footer> </section>
			<!--widget end-->
			<!--widget start-->
			
			<section class="panel">
			<div class="twt-feed blue-bg">
				<h1>王医生</h1>
				<a href="#"> <img src="img/doctor2.jpg" alt="">
				</a>
			</div>
			<div class="weather-category twt-category">
				<ul>
					<li class="active">
						<h5>中医科</h5> 科室
					</li>
					<li>
						<h5>副主任医师</h5> 职称
					</li>
					<li>
						<h5>4.78</h5> 评分
					</li>
				</ul>
			</div>
			<footer class="twt-footer">
			<button class="btn btn-space btn-white" data-toggle="button">
				查看详情</button>
			<button class="btn btn-space btn-info pull-right" type="button">
				<i class="icon-twitter"></i> 向他提问
			</button>
			</footer> </section>
			<!--widget end-->
		</div>
	</div>
	</section> </section>

	<jsp:include page="Script.jsp"></jsp:include>
</body>

</html>