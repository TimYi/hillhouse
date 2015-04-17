<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:base page="aboutus" lang="${lang }">
<jsp:body>
	<div class="crumb container">
		<c:if test="${lang ne 'CH' }">		
        <a href="<c:url value='/'/>" class="color-dangerous">Home</a>
        </c:if>
        <c:if test="${lang eq 'CH' }">		
        <a href="<c:url value='/ch'/>" class="color-dangerous">主页</a>
        </c:if>
        <span>></span>
        <a>${figure.firstname } ${figure.lastname }</a>
    </div>
    <div class="container mgb-2">
        <h2 class="bold inline">${figure.firstname } ${figure.lastname }</h2>
        <span class="h3 mgl-1">|</span>
        <h3 class="inline mgl-1">${figure.fullTitle }</h3>
        <div class="fg-content">
            <img src="${figure.avatar }"/>
            <div>
                <h3>${figure.summary }</h3><br/>
                <div>${figure.story }</div>
            </div>
        </div>
    </div>
</jsp:body>
</my:base>