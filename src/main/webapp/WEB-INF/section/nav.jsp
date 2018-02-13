<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"  onload="clockTimer();">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="/welcome">Orchid - market flowers</a>
	</div>
	<div class="sidebar-collapse collapse navbar-collapse navbar-ex1-collapse">
		<ul id="active" class="nav navbar-nav side-nav">
			<li class="selected"><a href="#" data-toggle="collapse" data-target="#demo1"><span class="fa arrow"></span> Single flower <span class="fa arrow"></span></a>
				<div id="demo1" class="collapse orchid-menu">
					<c:forEach var="category" items="${categorys }">
						<a href="/products/${category.url}">${category.name } </a><br>
					</c:forEach>
				</div>
			</li>
			<li><a href="#" data-toggle="collapse" data-target="#demo2"><span class="fa arrow"></span> Bouquet <span class="fa arrow"></span></a>
				<div id="demo2" class="collapse orchid-menu">
					<a href="/products">Rose </a><br>
					<a href="/products">Orchid </a><br>
					<a href="/products">Cactus </a><br>
					<a href="/products">Chamomile </a><br>
					<a href="/products">Gladiolus </a><br>
					<a href="/products">Petunia </a><br>
					<a href="/products">Tulip </a><br>
					<a href="/products">Chrysanthemus </a><br>
				</div>
			</li>
			<li><a href="/blog"> Blog</a></li>
			<li><a href="/signup"> SignUp</a></li>
			<li><a href="/register"> Register</a></li>
			<li><a href="/about-us"> About us</a></li>
			<li class="divider-horizontal-blod"></li>
		</ul>
		<ul class="nav navbar-nav navbar-right navbar-user">
			<li>
				<form class="navbar-search">
					<input type="text" placeholder="Search" class="form-control">
				</form>
			</li>
		</ul>
		<div class="compare-basket">
			<button class="action action--button action--compare">
				<i class="fa fa-check"></i>
					<span class="action__text">Сравнить</span>
			</button>
		</div>
	</div>
</nav>
