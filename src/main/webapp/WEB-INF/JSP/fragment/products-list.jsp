<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="product" items="${products }">
	<div class="col-md-4">
		<div class="well">
			<div class="price" data-toggle="tooltip" title="Гривна">${product.price }грн</div>
			<img class="thumbnail img-responsive center-block" alt="${product.name }" src="${product.photo }" style="height: 300px; width: 300px;"/> 
			<span> 
				<div class="size-orchid">
				Название: ${product.name } <br> 				
				</div>
				<div class="size-orchid">
				Категория: ${product.category.name } <br>				
				</div>
				<div class="size-orchid">
				Производитель: ${product.producer.name } <br>				
				</div>
				<hr> 
				<span class="btn-group btn-group-justified"> 
				<a href="/details?id=${product.id }" class="btn btn-default btn-sm">Details</a> 
				<!-- 
				<a href="/compare?id=${product.id }" class="btn btn-default btn-sm">Compare</a> 
								
				--> 
				<a href="/admin/edit-product?id=${product.id }" class="btn btn-default btn-sm">Edit</a>
				</span>
			</span>
			<label class="action action--compare-add">
				<input class="check-hidden" type="checkbox" />
				<i class="fa fa-plus"></i><i class="fa fa-check"></i>
				<span class="action__text action__text--invisible">Добавить для сравнения</span>
			</label>
		</div>
	</div>
</c:forEach>