<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Name</th>
			<th>URL</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<!-- 
			
		 --><c:if test="${fn:length(categorys) == 0 }">
			<tr>
				<td colspan="5">Список пуст</td>
			</tr>
		</c:if>	
		<c:forEach var="category" items="${categorys}">
			<tr>
				<td>${category.name}</td>
				<td>${category.url}</td>
				<td>
					<a href="/admin/deleteCategory?id=${category.id}" class="btn btn-danger btn-sm">Удалить</a>
					<a href="/admin/edit-category?id=${category.id}" class="btn btn-info btn-sm">Изменить</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>