
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="bsCss"
	value="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"></c:url>

<c:url var="bsJs" value="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></c:url>

<c:url var="popper" value="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></c:url>
<c:url var="jqJs" value="/webjars/jquery/3.6.0/jquery.min.js"></c:url>
<c:url var="font"
	value="/webjars/font-awesome/6.1.1/css/fontawesome.css"></c:url>
<c:url var = "summerJs" value = "/webjars/summernote/0.8.10/summernote.js"></c:url>
<c:url var = "summerCss" value = "/webjars/summernote/0.8.10/summernote.css"></c:url>

	

<link rel="stylesheet" href="${bsCss}" />

<script type="text/javascript" src="${bsJs}"></script>
<script type="text/javascript" src = "${popper}"></script>
<link rel="stylesheet" href="${font}" />
<script type="text/javascript" src="${jqJs}"></script>

<script type="text/javascript" src = "${summerJs}"></script>
<link rel="stylesheet" href="${summerCss}" />

