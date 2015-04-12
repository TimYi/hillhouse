<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hillhouse backetend</title>
    <link href="<c:url value='/resources/css/app.css'/>" type="text/css" rel="stylesheet"/>
</head>
<body>
    <div class="container-fluid">
        <nav class="navbar navbar-default">
            <div class="navbar-header">
                <a class="navbar-brand" href="<c:url value='/admin/ch'/>">hillhouse</a>
            </div>
            <div>
                <ul class="nav nav-tabs">
                    <li><a href="<c:url value='/admin'/>">EN</a></li>
                    <li class="active"><a href="<c:url value='/admin/ch'/>">中文</a></li>
                </ul>
            </div>
        </nav>
        <div class="row">
            <div class="col-sm-2">
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="<c:url value='/admin/ch/figure'/>">人物</a></li>
                    <li><a href="<c:url value='/admin/ch/news'/>">新闻</a></li>
                    <li><a href="<c:url value='/admin/ch/portfolionews'/>">趣事</a></li>
                    <li><a href="<c:url value='/admin/ch/portfolio'/>">伙伴</a></li>
                    <li><a href="<c:url value='/admin/ch/story'/>">故事</a></li>
                </ul>
            </div>
            <div class="col-sm-10">