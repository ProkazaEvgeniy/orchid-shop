<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Name</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<!-- 
				
		 --><c:if test="${fn:length(lenghts) == 0 }">
			<tr>
				<td colspan="5">Список пуст</td>
			</tr>
		</c:if>
		<c:forEach var="lenght" items="${lenghts}">
			<tr>
				<td>${lenght.name}</td>
				<td><a href="/admin/deleteLenght?id=${lenght.id}" class="btn btn-danger btn-sm">Удалить</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>