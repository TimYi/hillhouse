<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:base page="aboutus" lang="${lang }">
<jsp:attribute name="hmClass">
<c:if test="${lang eq 'EN' }" var="en">hm</c:if>
</jsp:attribute>
<jsp:attribute name="beforeHeader">	
<c:if test="${en }">
	<div id="hm-slide">
        <header class="header">
            <div class="logo"></div>
            <ul class="fl">
                <li class="bold"><a class="mgl-2">ABOUT US</a></li>
                <li class="bold"><a href="<c:url value='/storys'/>">ENTREPRENEUR STORIES</a></li>
		        <li class="bold"><a href="<c:url value='/portfolios'/>">PORTFOLIO</a></li>
		        <li class="bold"><a href="<c:url value='news'/>">NEWS</a></li>
            </ul>
            <ul class="fr">
                <li class="bold"><a href="<c:url value='/'/>" class="active">En</a></li>
                <li class="bold ch"><a href="<c:url value='/ch'/>">中文</a></li>
            </ul>
        </header>
        <div class="container text-center">
            <p class="hm-title">A fundamental equities investment firm focused on the long, long-term.</p>
            <div class="pointer" onclick="home()">
                <span class="hm-learn-more">LEARN MORE ABOUT US</span>
                <span class="hm-triangle"></span>
            </div>            
        </div>
    </div>   
    </c:if> 
</jsp:attribute>

<jsp:body>
	<div class="container mgt-1">
		<h2 class="mgt-2 bold"><c:if test="${en }">About Us</c:if><c:if test="${!en }">关于高瓴</c:if></h2>
		<p class="mgt-2 width-eighty">
		<c:if test="${en }">
		Hillhouse Capital Group (“Hillhouse”) is a leading investment management firm founded by Mr. Zhang Lei in 2005. We manage over US$18bn of assets as of Dec 2014. We manage capital for institutional clients such as university endowments, foundations, sovereign wealth funds, pensions and family offices. 
<br><br>
Hillhouse is a long-term fundamental equity investor with a global mandate.  Independent, fundamental and proprietary research is key to our investment process. Our team focuses on the consumer, TMT, industrials and healthcare sectors and invests in companies across all equity stages.
		</c:if>
		<c:if test="${!en }">
		 高瓴资本集团（以下简称“高瓴资本”）是一家专注于长期结构性价值投资的公司，由张磊先生于2005年创立。截止2014年年底，高瓴资本管理的资金规模超过180亿美金，受托管理的资金主要来自于目光长远的全球性机构投资人，包括大学捐赠基金、慈善基金、主权财富基金、养老基金及家族基金等。 
<br><br>
高瓴资本是具有全球视野的长期价值投资者。高瓴资本坚持独立思考，深入研究，主要投资于消费与零售、互联网与媒体、医疗健康、能源与制造业等行业里处于不同发展阶段的优秀企业。 
		</c:if>
          
        </p>
        <h2 class="mgt-2 bold"><c:if test="${en }">Our People</c:if><c:if test="${!en }">关于我们</c:if></h2>
        <div class="mgt-half clear-fix">
            <img class="hm-avatar fl" src="${figures[0].avatar }">
            <div class="width-seventy fl mgt-half mgl-1 clear-fix">
                <p class="bold font-bigger inline">${figures[0].lastname }</p>
                <p class="inline mgl-1">|</p>
                <p class="mgl-1 inline">${figures[0].title }</p>
                <pre class="mgt-1">${figures[0].introduction }</pre>
            	<a class="underline mgt-1 block" href="<c:if test="${en }"><c:url value='/figures/${figures[0].id }'/></c:if><c:if test="${!en }"><c:url value='/ch/figures/${figures[0].id }'/></c:if>">
            	<c:if test="${en }">Full Profile</c:if><c:if test="${!en }">详情</c:if> <span class="color-dangerous">></span>
            	</a>                                
            </div>
        </div>
	</div>
	<div class="container clear-fix mgb-2 mgt-1">
		<c:forEach items="${figures }" var="figure" varStatus="status">
			<c:if test="${status.index ne 0 }">
				<div class="hm-peoples mgt-2">
		            <p class="bold font-bigger inline">${figure.lastname }</p>
	                <p class="mgl-1 inline">|</p>
	                <p class="mgl-1 inline">${figure.title }</p>
	                <pre class="mgt-1">${figure.introduction }</pre>
	                <a class="underline mgt-1 block" href="<c:if test="${en }"><c:url value='/figures/${figure.id }'/></c:if><c:if test="${!en }"><c:url value='/ch/figures/${figure.id }'/></c:if>">
            	<c:if test="${en }">Full Profile</c:if><c:if test="${!en }">详情</c:if> <span class="color-dangerous">></span>
            	</a>              
		        </div>
			</c:if>	
			<c:if test="${status.index % 3 eq 0 }">
				<div class="clear"></div>
			</c:if>		
		</c:forEach>
    </div>
</jsp:body>
</my:base>
