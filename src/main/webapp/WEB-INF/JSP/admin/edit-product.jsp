<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"  isELIgnored="false"%>
<%@ taglib prefix="c"      	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"     	uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" 	uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="orchid" 	tagdir="/WEB-INF/tags"%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1>Welcome admin to edit product</h1>
			<div class="row">
				<form:form commandName="productForm" action="/admin/edit-product" method="post" cssClass="form-horizontal data-form" enctype="multipart/form-data">
					<div class="col-lg-8">
						<div class="well"><p class="text-primary">processing for product</p>
							<input	name="id" type="hidden"	value="${product.id}">
							<div class="form-group">
								<label for="inputPhoto" class="col-sm-2 control-label">Фото*</label>
								<div class="col-sm-5 btn-file">
									<img id="currentPhoto" src="${product.productPhoto }" class="edit-photo img-thumbnail center-block" style="margin-bottom:10px"/><br/> 
									<input type="file" name="productPhoto" id="productPhoto"/>
				
								</div>
								<div class="col-sm-5 help-block">
									<blockquote>
										<h4>Файл <small>должен быть в формате .jpg</small></h4>
									</blockquote>
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputCity" class="col-sm-2 control-label">Название*</label>
								<div class="col-sm-5">
									<input name="name" value="${product.name }" class="form-control" id="inputName" required="required" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPrice" class="col-sm-2 control-label">Цена*</label>
								<div class="col-sm-5">
									<input name="price" value="${product.price }" class="form-control" id="inputPrice" required="required" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputCount" class="col-sm-2 control-label">Колличество*</label>
								<div class="col-sm-5">
									<input name="count" value="${product.count }" class="form-control" id="inputCount" required="required" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputLenght" class="col-sm-2 control-label">Длина цветка*</label>
								<div class="col-sm-5">
									<select name="lenght" class="form-control">
										<c:forEach var="lenght" items="${lenghts }">
											<option value="${lenght.id }" ${lenght.id == product.lenght.id ? ' selected="selected"' : ''}>${lenght.name }</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-5 help-block">
									<blockquote>
										<h4>now ${product.lenght.name }</h4>
									</blockquote>
								</div>
							</div>
							<div class="form-group">
								<label for="inputProducer" class="col-sm-2 control-label">Производитель*</label>
								<div class="col-sm-5">
									<select name="producer" class="form-control">
										<c:forEach var="producer" items="${producers }">
											<option value="${producer.id }" ${producer.id == product.producer.id  ? ' selected="selected"' : ''}>${producer.name }</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-5 help-block">
									<blockquote>
											<h4>now ${product.producer.name }</h4>
									</blockquote>
								</div>
							</div>
							<div class="form-group">
								<label for="inputCategory" class="col-sm-2 control-label">Категория*</label>
								<div class="col-sm-5">
									<select name="category" class="form-control">
										<c:forEach var="category" items="${categorys }">
											<option value="${category.id }" ${category.id == product.category.id  ? ' selected="selected"' : ''}>${category.name }</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-5 help-block">
									<blockquote>
											<h4>now ${product.category.name }</h4>
									</blockquote>
								</div>
							</div>
							<div class="form-group">
								<label for="inputdescription" class="col-sm-2 control-label">Описание*</label>
								<div class="col-sm-5">
									<textarea name="description" class="form-control" id="inputdescription" rows="5">${product.description }</textarea>
								</div>
							</div>
							
							<div class="row">
								<div class="col-xs-12 text-center">
									<button type="submit" class="btn btn-primary btn-sm">Сохранить</button>
								</div>
							</div>
						</div>
					</div>
				</form:form>				
			</div>
		</div>
	</div>
</div>

<content tag="js-init">
	<script>
	$(document).ready(function(){
		orchid.createPhotoUploader();
	});
	</script>
</content>
