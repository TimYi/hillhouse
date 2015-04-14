<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:base page="storys" lang="ch" hmClass="ch">
<jsp:body>
	<div class="crumb container">
        <a href="<c:url value='/ch'/>" class="color-dangerous">主页</a>
        <span>></span>
        <a>企业故事</a>
    </div>
    <div class="container">
        <h2 class="bold mgb-1">企业故事</h2>
        <div class="es-figure">
            <img class="es-figure-image" src="${storys[0].img }">
            <div class="es-figure-description">
                <pre class="h2 mgt-1">${storys[0].summary }</pre>
                <pre class="mgt-1">${storys[0].content }</pre>
                <a href="<c:url value='/ch/storys/${storys[0].id }'/>" class="text-right mgt-1 block">
                    Full interview <span class="color-dangerous">></span>
                </a>
            </div>
        </div>
        <div class="mgt-2 clear-fix">
        	<c:forEach items="${storys }" var="story" varStatus="status">
        	<c:choose>
	        	<c:when test="${status.index eq 0 }">
	        	</c:when>
	        	<c:when test="${status.index % 4 eq 1 }">
	        		<div class="clear"></div>
	        		<div class="es-list">
		                <img src="${story.img }" />		
		                <div class="es-content">
		                    <h3>${story.summary }</h3>
		                    <pre class="mgt-2">${story.content }</pre>
		                    <a href="<c:url value='/ch/storys/${storys[0].id }'/>" class="text-right mgt-1 block">
		                        Full interview <span class="color-dangerous">></span>
		                    </a>
		                </div>
		            </div>
	        	</c:when>
	        	<c:otherwise>
	        		<div class="es-list es-margin">
		                <img src="${story.img }" />		
		                <div class="es-content">
		                    <h3>${story.summary }</h3>
		                    <pre class="mgt-2">${story.content }</pre>
		                    <a href="<c:url value='/ch/storys/${storys[0].id }'/>" class="text-right mgt-1 block">
		                        Full interview <span class="color-dangerous">></span>
		                    </a>
		                </div>
		            </div>
	        	</c:otherwise>
        	</c:choose>
        	</c:forEach>
        </div>
    </div>
</jsp:body>
</my:base>
    
