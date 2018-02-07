<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="orchid-shop" tagdir="/WEB-INF/tags"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12 text-center v-center">
			<h1>Sign Up</h1>
			<p class="lead">Enter your email to sign-up for our newsletter and registration</p>
			<br> <br> <br>
			<form:form action="/signup" commandName="signUpUserForm" method="post" class="col-lg-12">
				<div class="input-group" style="width: 340px; text-align: center; margin: 0 auto;">
					<input name="email" id="email" class="form-control input-lg" title="Confidential signup." placeholder="Enter your email address" type="text" /> <span class="input-group-btn">
						<button class="btn btn-lg btn-primary" type="submit">OK</button>
					</span>
				</div>
				<!-- 
				<div>
					<div class="col-lg-12">
						<label> 
							<input type="checkbox"> I hereby accept the terms and conditions for using this site
						</label>
					</div>
				</div>
				 -->
			</form:form>
		</div>
	</div>
	<ul id="sortable">
		<li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 1</li>
		<li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 2</li>
		<li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 3</li>
		<li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 4</li>
		<li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 5</li>
		<li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 6</li>
		<li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 7</li>
	</ul>
	<br> <br> <br> <br> <br> <br> <br> <br> <br>
	<div class="text-center">
		<h1>Follow us</h1>
	</div>
	<div class="row">
		<div class="col-lg-12 text-center v-center" style="font-size: 39pt;">
			<a href="#"><span class="avatar"><i class="fa fa-google-plus"></i></span></a> <a href="#"><span class="avatar"><i class="fa fa-facebook"></i></span></a>
		</div>
	</div>
	<!-- /.row -->
</div>