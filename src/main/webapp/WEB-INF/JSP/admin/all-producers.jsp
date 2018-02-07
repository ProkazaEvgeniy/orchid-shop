<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="orchid" tagdir="/WEB-INF/tags"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1>All Producers</h1>
				<div class="panel panel-default">
					<div class="panel-body">
						<p><a href="/admin/welcome" class="btn btn-info btn-sm">назад</a></p>
						<orchid:producer-table/>
					</div>
				</div>
		</div>
	</div>
</div>
