<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:base page="portfolio">
<jsp:body>
	<div class="crumb container">
		<c:if test="${lang eq 'EN' }" var="en">		
        <a href="<c:url value='/'/>" class="color-dangerous">Home</a>
        </c:if>
        <c:if test="${lang eq 'CH' }">		
        <a href="<c:url value='/ch'/>" class="color-dangerous">主页</a>
        </c:if>
        <span>></span>
        <a><c:if test="${en }">Portfolios</c:if><c:if test="${!en }">合作伙伴</c:if></a>
    </div>
    <div class="container mgb-2">
        <h2 class="bold"><c:if test="${en }">Portfolio Companies</c:if><c:if test="${!en }">兄弟企业</c:if></h2>
        <p class="mgt-2"><c:if test="${en }">Since 2005, Hillhouse has invested in many leading companies in their respective industries, below are selected portfolio companies:</c:if><c:if test="${!en }">自2005年成立以来，高瓴资本已先后投资了多家各行业领先企业，部分投资案例如下：</c:if></p>
        <div class="pf-lists">
        	<c:forEach items="${portfolios }" var="portfolio">
        		<div>
	                <a href="${portfolio.link }" target="_blank">
	                    <span class="helper"></span>
	                    <img src="${portfolio.url }"/>
	                </a>                
	            </div>
        	</c:forEach>
        </div>
    </div>
</jsp:body>
</my:base>