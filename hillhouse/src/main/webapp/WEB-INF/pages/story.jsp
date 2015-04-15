<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:base page="storys">
<jsp:body>
	<div class="crumb container">
        <c:if test="${lang eq 'EN' }" var="en">		
        <a href="<c:url value='/'/>" class="color-dangerous">Home</a>
        </c:if>
        <c:if test="${lang eq 'CH' }">		
        <a href="<c:url value='/ch'/>" class="color-dangerous">主页</a>
        </c:if>
        <span>></span>
        <a><c:if test="${en }">story</c:if><c:if test="${!en }">企业故事</c:if></a>
    </div>
    <div class="container mgb-2">
        <h2 class="bold inline">${story.title }</h2>
        <div class="fg-content">
            <img src="${story.img }"/>
            <div>
                <h3>${story.summary }</h3><br/>
                <pre>${story.content }</pre>
            </div>
        </div>
    </div>
</jsp:body>
</my:base>