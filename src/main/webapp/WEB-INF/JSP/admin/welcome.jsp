<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"  isELIgnored="false"%>
<%@ taglib prefix="c"      	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"     	uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" 	uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="orchid" 	tagdir="/WEB-INF/tags"%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1>Welcome admin</h1>
			<div class="row">
				<form:form commandName="productForm" action="/admin/save-product" method="post" cssClass="form-horizontal data-form" enctype="multipart/form-data">
					<div class="col-lg-8">
						<div class="well"><p class="text-primary">Add product <a href="/admin/all-products">Список всех продуктов </a></p>
							<div class="form-group">
								<label for="inputPhoto" class="col-sm-2 control-label">Фото*</label>
								<div class="col-sm-5 btn-file">
									<img id="currentPhoto" src="/static/img/product-placeholder.png" class="edit-photo img-thumbnail center-block" style="margin-bottom:10px"/><br/> 
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
									<input name="name" class="form-control" id="inputName" placeholder="Например: Роза Голандская" required="required" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPrice" class="col-sm-2 control-label">Цена*</label>
								<div class="col-sm-5">
									<input name="price" class="form-control" id="inputPrice" placeholder="Например: 10.50" required="required" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputCount" class="col-sm-2 control-label">Колличество*</label>
								<div class="col-sm-5">
									<input name="count" class="form-control" id="inputCount" placeholder="Например: 100" required="required" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputLenght" class="col-sm-2 control-label">Длина цветка*</label>
								<div class="col-sm-5">
									<select name="lenght" class="form-control">
										<c:forEach var="lenght" items="${lenghts }">
											<option value="${lenght.id }" ${lenght.id != null ? ' selected="selected"' : ''}>${lenght.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="inputProducer" class="col-sm-2 control-label">Производитель*</label>
								<div class="col-sm-5">
									<select name="producer" class="form-control">
										<c:forEach var="producer" items="${producers }">
											<option value="${producer.id }" ${producer.id != null ? ' selected="selected"' : ''}>${producer.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="inputCategory" class="col-sm-2 control-label">Категория*</label>
								<div class="col-sm-5">
									<select name="category" class="form-control">
										<c:forEach var="category" items="${categorys }">
											<option value="${category.id }" ${category.id != null ? ' selected="selected"' : ''}>${category.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="inputdescription" class="col-sm-2 control-label">Описание*</label>
								<div class="col-sm-5">
									<textarea name="description" class="form-control" id="inputdescription" rows="3"
										placeholder="Например: Краткое описание продукта"></textarea>
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
				<div class="col-lg-4">
					<div class="well"><p class="text-primary">Add category</p>
					<a href="/admin/all-categorys">Список всех категорий </a>
							<form:form commandName="categoryForm" action="/admin/save-category" method="post" cssClass="form-horizontal data-form">
								<div class="form-group">
									<label for="inputCategory" class="col-sm-12 control-label">Имя категории товара*</label>
									<div class="col-sm-12">
										<input name="name" class="form-control" id="inputCategory" placeholder="Например: Роза" required="required" />
									</div>
								
									<label for="inputURL" class="col-sm-12 control-label">URL*</label>
									<div class="col-sm-12">
										<input name="url" class="form-control" id="inputURL" placeholder="Например: rose (на английском языке)" required="required" />
									</div>
								</div>
						
								<div class="row">
									<div class="col-xs-12 text-center">
										<button type="submit" class="btn btn-primary btn-sm">Сохранить</button>
									</div>
								</div>
							</form:form>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="well"><p class="text-primary">Add producer</p>
					<a href="/admin/all-producers">Список всех производителей </a>
							<form:form commandName="producerForm" action="/admin/save-producer" method="post" cssClass="form-horizontal data-form">
								<div class="form-group">
									<label for="inputProducer" class="col-sm-12 control-label">Имя производителя*</label>
									<div class="col-sm-12">
										<input name="name" class="form-control" id="inputProducer" placeholder="Например: Голандия" required="required"/>
									</div>
								</div>
						
								<div class="row">
									<div class="col-xs-12 text-center">
										<button type="submit" class="btn btn-primary btn-sm">Сохранить</button>
									</div>
								</div>
							</form:form>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="well"><p class="text-primary">Add lenght</p>
					<a href="/admin/all-lenghts">Список всех длин цветов </a>
							<form:form commandName="lenghtForm" action="/admin/save-lenght" method="post" cssClass="form-horizontal data-form">
								<div class="form-group">
									<label for="inputLenght" class="col-sm-12 control-label">Имя длины*</label>
									<div class="col-sm-12">
										<input name="name" class="form-control" id="inputLenght" placeholder="Например: 30" required="required"/>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12 text-center">
										<button type="submit" class="btn btn-primary btn-sm">Сохранить</button>
									</div>
								</div>
							</form:form>
					</div>
				</div>
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
