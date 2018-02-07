<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="orchid" tagdir="/WEB-INF/tags"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1>Welcome admin to edit category</h1>
			<div class="row">
				<form:form commandName="categoryForm" action="/admin/edit-category" method="post" cssClass="form-horizontal data-form">
					<div class="form-group">
						<input	name="id" type="hidden"	value="${category.id}">
						<label for="inputCategory" class="col-sm-12 control-label">Имя категории товара*</label>
						<div class="col-sm-12">
							<input name="name" value="${category.name }" class="form-control" id="inputCategory" placeholder="Например: Роза" required="required" />
						</div>
						<label for="inputURL" class="col-sm-12 control-label">URL*</label>
						<div class="col-sm-12">
							<input name="url" value="${category.url }" class="form-control" id="inputURL" placeholder="Например: rose (на английском языке)" required="required" />
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 text-center">
							<button type="submit" class="btn btn-primary btn-sm">Сохранить</button>
							<a href="/admin/all-categorys" class="btn btn-info btn-sm">Назад</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
