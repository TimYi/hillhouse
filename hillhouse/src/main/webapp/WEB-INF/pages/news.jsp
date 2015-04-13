<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:base page="news">
<jsp:body>
	<div class="crumb container">
        <a href="<c:url value='/'/>" class="color-dangerous">Home</a>
        <span>></span>
        <a>News</a>
    </div>
    <div class="container clear-fix">
        <h2 class="bold">Features</h2>
        <c:forEach items="${news.result }" var="new" varStatus="status">
        	<div class="new-list">
	            <div>
	                <img src="${new.img }">
	                <div>
	                    <h4>${new.title }</h4>
	                    <p class="mgt-1">${new.date } | ${new.author } | ${new.origion }</p>
	                    <pre class="mgt-1">${new.summary }</pre>
	                    <a href="${new.link }" class="mgt-1 block">read the artical at ${new.linkShorthand } <span class="color-dangerous">></span></a>
	                </div>
	            </div>            
	        </div>
	        <c:if test="${status.index % 2 eq 1 }">
	        	<div class="clear"></div>
	        </c:if>
        </c:forEach>
        <div class="clear"></div>
        <div class="list-index mgt-4 mgb-2">
        	<c:forEach begin="1" end="${news.totalPage }" varStatus="status">
        		<c:if test="${status.count eq news.currentPage }" var="isActive">
        			<a href="<c:url value='/news?pageNo=${news.currentPage }&pageSize=8'/>" class="active">${status.count }</a>
        		</c:if>
        		<c:if test="${!isActive }">
        			<a href="<c:url value='/news?pageNo=${news.currentPage }&pageSize=8'/>">${status.count }</a>
        		</c:if>
        	</c:forEach>
        </div>
    </div>
</jsp:body>
</my:base>