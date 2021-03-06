<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="hmClass" %>
<%@ attribute name="lang" %>
<%@ attribute name="page" required="true" %>
<%@ attribute name="beforeHeader" fragment="true" %>
<!DOCTYPE html>
<c:choose>
	<c:when test="${empty hmClass }">
		<html>
	</c:when>
	<c:otherwise>
		<html class="${hmClass }">
	</c:otherwise>
</c:choose>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hillhouse Capital Group</title>
    <link href="<c:url value='/resources/css/common.css'/>" rel="stylesheet">
    <script src="<c:url value='/resources/js/jquery-1.11.1.js'/>"></script>
    <script src="<c:url value='/resources/js/jquery-cookie.js'/>"></script>
    <!-- <script src="<c:url value='/resources/js/less.js'/>"></script> -->
    <script src="<c:url value='/resources/js/common.js'/>"></script>     
</head>
<body>
	<jsp:invoke fragment="beforeHeader"/>
	<div id="body">
	<header class="header">
        <div class="logo" onclick="window.location.href=<c:url value='/'/>"></div>
        <ul class="fl">
        <c:if test="${lang ne 'CH' }"> 
        	<c:choose>
				<c:when test="${page eq 'aboutus' }">
					<li class="bold"><a class="mgl-2 active">ABOUT US</a></li>
		            <li class="bold"><a href="<c:url value='/storys'/>">ENTREPRENEUR STORIES</a></li>
		            <li class="bold"><a href="<c:url value='/portfolios'/>">PORTFOLIO</a></li>
		            <li class="bold"><a href="<c:url value='/news/1'/>">NEWS</a></li>
				</c:when>
				<c:when test="${page eq 'storys' }">
					<li class="bold"><a href="<c:url value='/'/>" class="mgl-2">ABOUT US</a></li>
		            <li class="bold"><a class="active">ENTREPRENEUR STORIES</a></li>
		            <li class="bold"><a href="<c:url value='/portfolios'/>">PORTFOLIO</a></li>
		            <li class="bold"><a href="<c:url value='/news/1'/>">NEWS</a></li>
				</c:when>
				<c:when test="${page eq 'portfolio' }">
					<li class="bold"><a href="<c:url value='/'/>" class="mgl-2">ABOUT US</a></li>
		            <li class="bold"><a href="<c:url value='/storys'/>" >ENTREPRENEUR STORIES</a></li>
		            <li class="bold"><a class="active">PORTFOLIO</a></li>
		            <li class="bold"><a href="<c:url value='/news/1'/>">NEWS</a></li>
				</c:when>
				<c:otherwise>
					<li class="bold"><a href="<c:url value='/'/>" class="mgl-2">ABOUT US</a></li>
		            <li class="bold"><a href="<c:url value='/storys'/>">ENTREPRENEUR STORIES</a></li>
		            <li class="bold"><a href="<c:url value='/portfolios'/>">PORTFOLIO</a></li>
		            <li class="bold"><a class="active">NEWS</a></li>
				</c:otherwise>
			</c:choose>
		</c:if>
		<c:if test="${lang eq 'CH' }">
        	<c:choose>
				<c:when test="${page eq 'aboutus' }">
					<li class="bold"><a class="mgl-2 active">关于我们</a></li>
		            <li class="bold"><a href="<c:url value='/ch/storys'/>">企业故事</a></li>
		            <li class="bold"><a href="<c:url value='/ch/portfolios'/>">合作伙伴</a></li>
		            <li class="bold"><a href="<c:url value='/ch/news/1'/>">最新消息</a></li>
				</c:when>
				<c:when test="${page eq 'storys' }">
					<li class="bold"><a href="<c:url value='/ch'/>" class="mgl-2">关于我们</a></li>
		            <li class="bold"><a class="active">企业故事</a></li>
		            <li class="bold"><a href="<c:url value='/ch/portfolios'/>">合作伙伴</a></li>
		            <li class="bold"><a href="<c:url value='/ch/news/1'/>">最新消息</a></li>
				</c:when>
				<c:when test="${page eq 'portfolio' }">
					<li class="bold"><a href="<c:url value='/ch'/>" class="mgl-2">关于我们</a></li>
		            <li class="bold"><a href="<c:url value='/ch/storys'/>" >企业故事</a></li>
		            <li class="bold"><a class="active">合作伙伴</a></li>
		            <li class="bold"><a href="<c:url value='/ch/news/1'/>">最新消息</a></li>
				</c:when>
				<c:otherwise>
					<li class="bold"><a href="<c:url value='/ch'/>" class="mgl-2">关于我们</a></li>
		            <li class="bold"><a href="<c:url value='/ch/storys'/>">企业故事</a></li>
		            <li class="bold"><a href="<c:url value='/ch/portfolios'/>">合作伙伴</a></li>
		            <li class="bold"><a class="active">最新消息</a></li>
				</c:otherwise>
			</c:choose>
		</c:if>
        </ul>
        <ul class="fr">
        	<c:choose>
				<c:when test="${lang eq 'CH' }">
					<li class="bold"><a href="<c:url value='/'/>">En</a></li>
            		<li class="bold ch"><a class="active">中文</a></li>
				</c:when>
				<c:otherwise>
					<li class="bold en"><a href="<c:url value='/'/>" class="active">En</a></li>
            		<li class="bold ch"><a href="<c:url value='/ch'/>">中文</a></li>
				</c:otherwise>
			</c:choose>
        </ul>
    </header>	
	<div class="main_pic"></div>
	<jsp:doBody/>
	
    <div class="contact font-small">
        <div class="container contact-container clear-fix">
            <div class="contact-us">
                <h2 class="mgt-1"><span class="bold">Contact </span>Us</h2>
                <form id="contact" action="<c:url value='/contact'/>" method="post">
                <div class="clear-fix">
                    <div class="contact-content">
                        <label for="name">YOUR NAME</label>
                        <input type="text" name="name"/>
                        <label for="eamil">YOUR EMAIL</label>
                        <input type="email" name="email"/>
                        <label for="subject">SUBJECT</label>
                        <input type="text" name="subject"/>
                    </div>
                    <div class="contact-content">
                        <label for="message">YOUR MESSAGE</label>
                        <textarea name="message" placeholder="write message here"></textarea>
                    </div>                    
                </div>
                    <button type="submit">SEND MESSAGE</button>
                </form>                
            </div>                
            <div class="contact-description">
                <p class="mgt-4">Zhang Lei earned an MBA and M.A. in International Relations from Yale University and a B.A. in Economics from Renmin University of China, where he is the Vice Chairman and Trustee of the Board. In addition,</p>
            </div>
        </div>        
    </div>
    <div class="footer">
        <div class="container">
            <div class="inline-block font-small">© 2015 Hillhouse Capital Management, All Rights Reserved. Use of this website is governed by the Terms of Use.</div>
            <a class="inline-block font-small mgl-2">More information</a>
            <a id="contact" class="inline-block font-small mgl-3" onclick="contact()">Contact</a>
            <a class="inline-block font-small mgl-3">Legal</a>
        </div>
    </div> 
    </div>   
</body>
</html>