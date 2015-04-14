<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:base hmClass="hm" page="aboutus">
<jsp:attribute name="beforeHeader">
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
</jsp:attribute>
<jsp:body>
	<div class="container">
		<h2 class="mgt-1">About Us</h2>
		<p class="mgt-1 width-eighty">
          Hillhouse Capital Group (“Hillhouse”) is a leading investment management firm founded by Mr. Zhang Lei in 2005. We manage over US$18bn of assets as of Dec 2014. We manage capital for institutional clients such as university endowments, foundations, sovereign wealth funds, pensions and family offices. 
<br><br>
Hillhouse is a long-term fundamental equity investor with a global mandate.  Independent, fundamental and proprietary research is key to our investment process. Our team focuses on the consumer, TMT, industrials and healthcare sectors and invests in companies across all equity stages.
        </p>
        <h2 class="mgt-1">Our People</h2>
        <div class="mgt-half clear-fix">
            <img class="fl" src="${figures[0].avatar }">
            <div class="width-seventy fl mgt-half mgl-1 clear-fix">
                <a class="bold">${figures[0].lastname }</a>
                <p class="inline mgl-1">|</p>
                <a class="mgl-1">${figures[0].title }</a>
                <pre class="mgt-1">${figures[0].summary }</pre>
            	<a class="underline mgt-1 block" href="<c:url value='/figures/${figures[0].id }'/>">Full Profile <span class="color-dangerous">></span></a>                                
            </div>
        </div>
	</div>
	<div class="container clear-fix mgb-2 mgt-1">
		<c:forEach items="${figures }" var="figure" varStatus="status">
			<c:if test="${status.index ne 0 }">
				<div class="hm-peoples mgt-2">
		            <a class="bold">${figure.lastname }</a>
	                <p class="mgl-1 inline">|</p>
	                <a class="mgl-1">${figure.title }</a>
	                <pre class="mgt-1">${figure.summary }</pre>
	                <a class="underline mgt-1 block" href="<c:url value='/figures/${figure.id }'/>">Full Profile <span class="color-dangerous">></span></a>                
		        </div>
			</c:if>			
		</c:forEach>
    </div>
</jsp:body>
</my:base>
