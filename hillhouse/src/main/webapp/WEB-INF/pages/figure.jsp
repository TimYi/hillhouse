<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:base page="aboutus">
<jsp:body>
	<div class="crumb container">
        <a href="<c:url value='/'/>" class="color-dangerous">Home</a>
        <span>></span>
        <a>${figure.firstname } ${figure.lastname }</a>
    </div>
    <div class="container mgb-2">
        <h2 class="bold inline">${figure.firstname } ${figure.lastname }</h2>
        <span class="h2">| </span>
        <h3 class="inline">${figure.fullTitle }</h3>
        <div class="fg-content">
            <img src="${figure.avatar }"/>
            <div>
                <h4>${figure.summary }</h4><br/>
                <pre>${figure.story }</pre>
            </div>
        </div>
    </div>
</jsp:body>
</my:base>