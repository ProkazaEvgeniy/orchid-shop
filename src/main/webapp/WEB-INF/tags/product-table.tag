<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Photo</th>
			<th>Data</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<!-- 
			
		 --><c:if test="${fn:length(products) == 0 }">
			<tr>
				<td colspan="5">Список пуст</td>
			</tr>
		</c:if>	
		<c:forEach var="product" items="${products}">
			<tr>
				<td><img src="${product.photo }" style="height: 50px; width: 50px;"/></td>
				<td>
				ID - ${product.id}<br/>
				Name - ${product.name}<br/>
				Price - ${product.price}<br/>
				Count - ${product.count}<br/>
				Length - ${product.lenght.name}<br/>
				Producer - ${product.producer.name}<br/>
				Category - ${product.category.name}<br/>
				Description - ${product.description}
				</td>
				<td>
					<a href="/admin/deleteProduct?id=${product.id}" class="btn btn-danger btn-xs">Удалить</a>
					<br/><br/>
					<a href="/admin/edit-product?id=${product.id}" class="btn btn-info btn-xs">Изменить</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>