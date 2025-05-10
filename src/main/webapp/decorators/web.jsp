<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title><dec:title default="Thái minh" /></title>
  <link href="<c:url value='/template/web/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css">
  <link href="<c:url value='/template/web/css/style.css'/>" rel="stylesheet" type="text/css">
   
  <!-- Ajax -->
  <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
  
  <!-- sweetalert -->
   <script src="<c:url value='/template/admin/sweetalert/sweetalert2.min.js' />"></script>
   <link rel="stylesheet" href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />" /> 
</head>
<body>
	<%@ include file="/common/web/header.jsp" %>

	<dec:body/>

	<%@ include file="/common/web/footer.jsp" %>

	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value='/template/web/js/jquery.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/bootstrap.min.js'/>"></script>
</body>
</html>