<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:base page="portfolio" lang="ch" hmClass="ch">
<jsp:body>
	<div class="crumb container">
        <a href="<c:url value='/ch'/>" class="color-dangerous">主页</a>
        <span>></span>
        <a>合作伙伴</a>
    </div>
    <div class="container mgb-2">
        <h2 class="bold">兄弟企业</h2>
        <p class="mgt-2">自2005年成立以来，高瓴资本已先后投资了多家各行业领先企业，部分投资案例如下：</p>
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