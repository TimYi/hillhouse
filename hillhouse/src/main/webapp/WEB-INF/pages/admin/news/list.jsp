<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>

<my:admin lang="${lang }">
<button onclick="add('<c:if test="${lang eq 'EN' }" var="en"><c:url value='/admin/news'/></c:if><c:if test="${!en }"><c:url value='/admin/ch/news'/></c:if>')" class="btn btn-default mgt-1">添加</button>               
                <table class="table table-bordered text-center mgt-2">
                    <thead>
                        <tr>
                            <th>title</th>
                            <th>author</th>
                            <th>origion</th>
                            <th>修改</th>
                            <th>删除</th>
                        </tr>
                    </thead>                        
                    <tbody>
                    	<c:forEach items="${ts }" var="t">
                    		<tr id="${t.id }">
	                            <td>${t.title }</td>
	                            <td>${t.author }</td>
	                            <td>${t.origion }</td>
	                            <td><a onclick="edit('<c:if test="${en }"><c:url value='/admin/news'/></c:if><c:if test="${!en }"><c:url value='/admin/ch/news'/></c:if>','${t.id}')">修改</a>
	                            <td><a onclick="del('<c:if test="${en }"><c:url value='/admin/news'/></c:if><c:if test="${!en }"><c:url value='/admin/ch/news'/></c:if>','${t.id}')">删除</a>
	                        </tr>
                    	</c:forEach>
                    </tbody>
                </table>
</my:admin>
	
