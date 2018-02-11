<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="/static/css/app-product.css" />
<!-- /CSS -->
<!-- Modernizr -->
<script src="/static/js/modernizr.custom.js"></script>
<div class="view" id="page-wrapper">
		<div class="row product" >
			<div id="productContainer" data-product-total="${page.totalPages }" data-product-number="${page.number }">
				<jsp:include page="../JSP/fragment/products-list.jsp"/>
			</div>	
		</div>
		<c:if test="${page.number < page.totalPages - 1}">
			<div id="loadMoreContainer" class="col-xs-12">
				<a id="loadMore" class="btn btn-default btn-lg btn-block">Загрузить еще</a>
			</div>
			<div id="loadMoreIndicator" class="col-xs-12 text-center" style="display:none;">
				<img src="/static/img/large-loading.gif" alt="loading..."/>
			</div>
		</c:if>
	
	<!-- блок сравнения продуктов -->
		<section class="compare">
			<button class="action action--close"><i class="fa fa-remove"></i></button>
		</section>
		<script src="/static/js/classie.js"></script>
		<script src="/static/js/test01.js"></script>
	
</div>