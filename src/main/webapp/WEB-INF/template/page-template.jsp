<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Орхидея</title>
    <!-- CSS -->
    <jsp:include page="../section/css.jsp"/>
    <!-- /CSS -->
    <!-- JavaScript -->
	<jsp:include page="../section/js.jsp"/>
	<!-- /JavaScript -->
</head>
<body>
	<div id="wrapper">
		<!-- Nav bar -->
		<jsp:include page="../section/nav.jsp"/>	
		<!-- /Nav Bar -->
		<sitemesh:write property='body' />
		<!-- Footer -->
		<jsp:include page="../section/footer.jsp"/>
		<!-- /Footer -->
		<!-- JavaScript app -->
		<jsp:include page="../section/js-app.jsp"/>
		<!-- /JavaScript app-->
		<sitemesh:write property='page.js-init' />
    </div>
</body>
</html>