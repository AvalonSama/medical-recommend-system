<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Head.jsp"></jsp:include>

<body class="login-body">
	<div class="container">

		<form class="form-signin" action="LoginAction" method = "post">
			<h2 class="form-signin-heading">Login now</h2>
			<div class="login-wrap">
				<input type="text" class="form-control" placeholder="User ID" autofocus value="E-mail" name="email"> 
				<input type="password" class="form-control" placeholder="Password" name="pwd"> 
				<label class="checkbox">
					<div class="radios">
						<label class="label_radio" for="radio-01" name="User"> <input
							name="roleradio" id="radio-01" value="User" type="radio" checked />
							Login as an User
						</label> <label class="label_radio" for="radio-02" name="Doctor"> <input
							name="roleradio" id="radio-02" value="Doctor" type="radio" /> 
							Login as an Doctor
						</label>
						<label class="label_radio" for="radio-03" name="Administrator"> <input
                            name="roleradio" id="radio-03" value="Administrator" type="radio" /> 
                            Login as an Administrator
                        </label>
					</div>
				</label>
				<button class="btn btn-lg btn-login btn-block" type="submit"> Login</button>
			</div>
		</form>

	</div>
</body>
<jsp:include page="Script.jsp"></jsp:include>
</html>