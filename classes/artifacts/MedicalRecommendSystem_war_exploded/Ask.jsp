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
			我的提问 </header>
			<form class="form-horizontal" id="default" methon="post" action="AskAction">
				<fieldset title="Step1" class="step" id="default-step-0">
					<legend> </legend>
					<div class="form-group">
						<label class="col-lg-2 control-label">问题题目</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" name="QuestionTitle" placeholder="题目">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">请选择科室</label> 
						<div class="col-lg-10"><select
							class="form-control m-bot15" id="selectClass" name="SelectClass">
							<option>内科</option>
							<option>外科</option>
							<option>儿科</option>
							<option>五官科</option>
						</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">问题内容</label>
						<div class="col-lg-10">
							<textarea class="form-control" name="QuestionText" cols="60" rows="15"></textarea>
						</div>
					</div>
					<input type="submit" class="finish btn btn-danger" value="Finish" />
				</fieldset>

			</form>
		</div>
	</section>
	</div>
	</div>
	<!-- page end--> </section>
	</section>
	<!--main content end-->
	</section>

	<jsp:include page="Script.jsp"></jsp:include>
</body>
</html>