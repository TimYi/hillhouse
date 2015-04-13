<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:base page="news" lang="ch" hmClass="ch">
<jsp:body>
	<div class="crumb container">
        <a href="<c:url value='/'/>" class="color-dangerous">主页</a>
        <span>></span>
        <a>最新消息</a>
    </div>
    <div class="container clear-fix">
        <h2 class="bold">最新消息</h2>
        <c:forEach items="${news.result }" var="n" varStatus="status">
        	<div class="new-list">
	            <div>
	                <img src="${n.img }">
	                <div>
	                    <h4>${n.title }</h4>
	                    <p class="mgt-1"><fmt:formatDate value="${n.date }" pattern="yyyy-MM-dd"/> | ${n.author } | ${n.origion }</p>
	                    <pre class="mgt-1">${n.summary }</pre>
	                    <a href="${n.link }" target="_blank" class="mgt-1 block">read the artical at ${n.linkShorthand } <span class="color-dangerous">></span></a>
	                </div>
	            </div>            
	        </div>
	        <c:if test="${status.index % 2 eq 1 }">
	        	<div class="clear"></div>
	        </c:if>
        </c:forEach>
        <div class="clear"></div>
        <div class="list-index mgt-4 mgb-2">
        	<c:forEach begin="1" end="${news.totalPages }" varStatus="status">
        		<c:if test="${status.count eq news.pageNo }" var="isActive">
        			<a href="<c:url value='/news?pageNo=${news.pageNo }&pageSize=8'/>" class="active">${status.count }</a>
        		</c:if>
        		<c:if test="${!isActive }">
        			<a href="<c:url value='/news?pageNo=${status.count }&pageSize=8'/>">${status.count }</a>
        		</c:if>
        	</c:forEach>
        </div>
    </div>
</jsp:body>
</my:base>