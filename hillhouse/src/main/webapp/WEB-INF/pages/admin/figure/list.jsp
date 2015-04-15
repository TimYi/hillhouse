<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>

<my:admin lang="${lang }">
<button onclick="add('<c:url value='/admin/figure'/>')" class="btn btn-default mgt-1">添加</button>               
                <table class="table table-bordered text-center mgt-2">
                    <thead>
                        <tr>
                            <th>firstname</th>
                            <th>lastname</th>
                            <th>title</th>
                            <th>full-title</th>
                            <th>修改</th>
                            <th>删除</th>
                        </tr>
                    </thead>                        
                    <tbody>
                    	<c:forEach items="${ts }" var="t">
                    		<tr id="${t.id }">
	                            <td>${t.firstname }</td>
	                            <td>${t.lastname }</td>
	                            <td>${t.title }</td>
	                            <td>${t.fullTitle }</td>
	                            <td><a onclick="edit('<c:url value='/admin/figure'/>','${t.id}')">修改</a>
	                            <td><a onclick="del('<c:url value='/admin/figure'/>','${t.id}')">删除</a>
	                        </tr>
                    	</c:forEach>
                    </tbody>
                </table>
</my:admin>
	