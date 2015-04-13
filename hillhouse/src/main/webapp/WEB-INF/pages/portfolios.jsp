<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:base page="portfolio">
<jsp:body>
	<div class="crumb container">
        <a href="<c:url value='/'/>" class="color-dangerous">Home</a>
        <span>></span>
        <a>Portfolios</a>
    </div>
    <div class="container mgb-2">
        <h2 class="bold">Portfolio Companies</h2>
        <p class="mgt-2">Since 2005, Hillhouse has invested in many leading companies in their respective industries, below are selected portfolio companies:</p>
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