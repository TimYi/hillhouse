<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:base page="storys">
<jsp:body>
	<div class="crumb container">
        <a href="<c:url value='/'/>" class="color-dangerous">Home</a>
        <span>></span>
        <a>story</a>
    </div>
    <div class="container mgb-2">
        <h2 class="bold inline">${story.title }</h2>
        <div class="fg-content">
            <img src="${story.img }"/>
            <div>
                <h4>${story.summary }</h4><br/>
                <pre>${story.content }</pre>
            </div>
        </div>
    </div>
</jsp:body>
</my:base>