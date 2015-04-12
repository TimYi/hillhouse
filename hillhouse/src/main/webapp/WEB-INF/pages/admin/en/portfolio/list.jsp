<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
	<button onclick="add('<c:url value='/admin/portfolio'/>')" class="btn btn-default mgt-1">添加</button>               
                <table class="table table-bordered text-center mgt-2">
                    <thead>
                        <tr>
                            <th>name</th>
                            <th>link</th>
                            <th>查看</th>
                            <th>修改</th>
                            <th>删除</th>
                        </tr>
                    </thead>                        
                    <tbody>
                    	<c:forEach items="${ts }" var="t">
                    		<tr id="${t.id }">
	                            <td>${t.name }</td>
	                            <td>${t.link }</td>
	                            <td><a onclick="info('<c:url value='/admin/portfolio'/>','${t.id}')">查看</a>
	                            <td><a onclick="edit('<c:url value='/admin/portfolio'/>','${t.id}')">修改</a>
	                            <td><a onclick="del('<c:url value='/admin/portfolio'/>','${t.id}')">删除</a>
	                        </tr>
                    	</c:forEach>
                    </tbody>
                </table>

<%@ include file="../footer.jsp" %>