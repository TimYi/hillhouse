<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:base page="aboutus" lang="ch" hmClass="ch">
<jsp:body>
	<div class="container">
		<h2 class="mgt-1">关于高瓴</h2>
		<p class="mgt-1 width-eighty">
          高瓴资本集团（以下简称“高瓴资本”）是一家专注于长期结构性价值投资的公司，由张磊先生于2005年创立。截止2014年年底，高瓴资本管理的资金规模超过180亿美金，受托管理的资金主要来自于目光长远的全球性机构投资人，包括大学捐赠基金、慈善基金、主权财富基金、养老基金及家族基金等。 
<br><br>
高瓴资本是具有全球视野的长期价值投资者。高瓴资本坚持独立思考，深入研究，主要投资于消费与零售、互联网与媒体、医疗健康、能源与制造业等行业里处于不同发展阶段的优秀企业。 
        </p>
        <h2 class="mgt-1">关于我们</h2>
        <div class="mgt-half clear-fix">
            <img class="fl" src="${figures[0].avatar }">
            <div class="width-seventy fl mgt-half mgl-1 clear-fix">
                <a class="bold">${figures[0].lastname }</a>
                <p class="inline mgl-1">|</p>
                <a class="mgl-1">${figures[0].title }</a>
                <pre class="mgt-1">${figures[0].summary }</pre>
            	<a class="underline mgt-1 block" href="<c:url value='/ch/figures/${figures[0].id }'/>">详情 <span class="color-dangerous">></span></a>                                
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
	                <a class="underline mgt-1 block" href="<c:url value='/ch/figures/${figure.id }'/>">详情 <span class="color-dangerous">></span></a>                
		        </div>
			</c:if>		
			<c:if test="${status.index % 3 eq 3 }">
				<div class="clear"></div>
			</c:if>	
		</c:forEach>
    </div>
</jsp:body>
</my:base>
