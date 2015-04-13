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
    <link href="<c:url value='/resources/css/common.less'/>" rel="stylesheet/less">
</head>
<body>
	<jsp:invoke fragment="beforeHeader"/>
	<div id="body">
	<header class="header">
        <div class="logo" onclick="<c:url value='/'/>"></div>
        <ul class="fl">
        	<c:choose>
				<c:when test="${page eq 'aboutus' }">
					<li class="bold"><a class="mgl-2 active">ABOUT US</a></li>
		            <li class="bold"><a href="<c:url value='/storys'/>">ENTREPRENEUR STORIES</a></li>
		            <li class="bold"><a href="<c:url value='/portfolios'/>">PORTFOLIO</a></li>
		            <li class="bold"><a href="<c:url value='news'/>">NEWS</a></li>
				</c:when>
				<c:when test="${page eq 'storys' }">
					<li class="bold"><a href="<c:url value='/'/>" class="mgl-2">ABOUT US</a></li>
		            <li class="bold"><a class="active">ENTREPRENEUR STORIES</a></li>
		            <li class="bold"><a href="<c:url value='/portfolios'/>">PORTFOLIO</a></li>
		            <li class="bold"><a href="<c:url value='news'/>">NEWS</a></li>
				</c:when>
				<c:when test="${page eq 'portfolio' }">
					<li class="bold"><a href="<c:url value='/'/>" class="mgl-2">ABOUT US</a></li>
		            <li class="bold"><a href="<c:url value='/storys'/>" class="active">ENTREPRENEUR STORIES</a></li>
		            <li class="bold"><a class="active">PORTFOLIO</a></li>
		            <li class="bold"><a href="<c:url value='news'/>">NEWS</a></li>
				</c:when>
				<c:otherwise>
					<li class="bold"><a href="<c:url value='/'/>" class="mgl-2">ABOUT US</a></li>
		            <li class="bold"><a href="<c:url value='/storys'/>" class="active">ENTREPRENEUR STORIES</a></li>
		            <li class="bold"><a href="<c:url value='/portfolios'/>">PORTFOLIO</a></li>
		            <li class="bold"><a class="active">NEWS</a></li>
				</c:otherwise>
			</c:choose>
        </ul>
        <ul class="fr">
        	<c:choose>
				<c:when test="${lang eq 'ch' }">
					<li class="bold"><a href="<c:url value='/'/>">En</a></li>
            		<li class="bold ch"><a "<c:url value='/ch'/>" class="active">中文</a></li>
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
	
    <div class="contact">
        <div class="container pt-2 pb-2 clear-fix">
            <div class="contact-us">
                <h2><span class="bold">Contact </span>Us</h2>
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
                <p class="mgt-2">Zhang Lei earned an MBA and M.A. in International Relations from Yale University and a B.A. in Economics from Renmin University of China, where he is the Vice Chairman and Trustee of the Board. In addition,</p>
            </div>
        </div>        
    </div>
    <div class="footer">
        <div class="container">
            <div class="inline-block font-small">© 2015 Hillhouse Capital Management, All Rights Reserved. Use of this website is governed by the Terms of Use.</div>
            <a class="inline-block font-small mgl-1">More information</a>
            <a id="contact" class="inline-block font-small mgl-1" onclick="contact()">Contact</a>
            <a class="inline-block font-small mgl-1">Legal</a>
        </div>
    </div> 
    </div>   
    <script src="<c:url value='/resources/js/jquery-1.11.1.js'/>"></script>
    <script src="<c:url value='/resources/js/jquery-cookie.js'/>"></script>
    <script src="<c:url value='/resources/js/common.js'/>"></script>
    <script src="<c:url value='/resources/js/less.js'/>"></script>
</body>
</html>