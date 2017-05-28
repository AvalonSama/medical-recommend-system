<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Head.jsp"></jsp:include>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="row">
		<div class="col-lg-2"></div>
		<div class="col-lg-7">
			<section id="main-content"> <section class="wrapper">
			<section class="panel"> <a class="logo">Doctor <span>REGIST</span></a>
			<header class="panel-heading"> &nbsp </header>


			<div class="panel-body">
				<form class="form-horizontal" role="form" method="post" action="RegistServlet">
					<div class="form-group">
						<label for="inputUsername" class="col-lg-2 control-label">UserName</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="inputUsername"
								placeholder="UserName" name="inputUsername">
							<p class="help-block">Please input your user name.</p>
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword" class="col-lg-2 control-label">Password</label>
						<div class="col-lg-10">
							<input type="password" class="form-control" id="inputPassword"
								placeholder="Password" name="inputPassword">
							<p class="help-block">Please input your password.</p>
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail" class="col-lg-2 control-label">Email</label>
						<div class="col-lg-10">
							<input type="email" class="form-control" id="inputEmail"
								placeholder="Email" name="inputEmail">
							<p class="help-block">Please input your E-mail</p>
						</div>
					</div>
					<div class="form-group">
						<label for="inputTel" class="col-lg-2 control-label">TEL</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="inputTel"
								placeholder="TEL" name="inputTel">
							<p class="help-block">Please input your telephone number</p>
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail1" class="col-lg-2 control-label">Hospital</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="inputHospital"
								placeholder="Hospital" name="inputHospital">
							<p class="help-block">Please input your hospital</p>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-2" for="inputSuccess">Class</label>
						<div class="col-lg-10">
							<select class="form-control m-bot15" id="selectClass" name="selectClass">
								<option>内科</option>
								<option>外科</option>
								<option>妇产科</option>
								<option>儿科</option>
								<option>中医科</option>
								<option>五官科</option>
								<option>心理科</option>
							</select>
							<p class="help-block">Please select your class</p>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-2" for="selectGrade">Grade</label>
						<div class="col-lg-10">
							<select class="form-control m-bot15" id="selectGrade" name="selectGrade">
								<option>医师</option>
								<option>主管医师</option>
								<option>副主任医师</option>
								<option>主任医师</option>
							</select>
							<p class="help-block">Please select your grade</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">Introduction</label>
						<div class="col-lg-10">
							<textarea class="form-control" cols="60" rows="5" id="textIntroduction" name="textIntroduction"></textarea>
							<p class="help-block">Please input your introduction</p>
						</div>
						
					</div>
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<button type="submit" class="btn btn-success">Sign up</button>
							<button type="submit" class="btn btn-danger">Back</button>
						</div>
						
					</div>
				</form>
			</div>
		</div>
		</section>
		</section>
		</section>
	</div>
</body>
<jsp:include page="Script.jsp"></jsp:include>
</html>