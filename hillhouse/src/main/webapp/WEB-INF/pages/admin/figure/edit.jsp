<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>

<my:admin lang="${lang }">
	<form role="form" class="form-horizontal" method="post" enctype="multipart/form-data">
           <div class="form-group">
               <label for="media" class="col-sm-2 control-label"><img src="${t.avatar }"></label>
               <div class="col-sm-10">
                   <input type="file" class="form-control" name="media">
               </div>
           </div>
           <div class="form-group">
               <label for="firstname" class="col-sm-2 control-label">firstname:</label>
               <div class="col-sm-10">
                   <input value="${t.firstname }" type="text" class="form-control" name="firstname" placeholder="please input firstname">
               </div>
           </div>
           <div class="form-group">
               <label for="lastname" class="col-sm-2 control-label">lastname:</label>
               <div class="col-sm-10">
                   <input value="${t.lastname }" type="text" class="form-control" name="lastname" placeholder="please input lastname">
               </div>
           </div>
           <div class="form-group">
               <label for="priority" class="col-sm-2 control-label">priority:</label>
               <div class="col-sm-10">
                   <input value="${t.priority }" type="number" class="form-control" name="priority" placeholder="please input title">
               </div>
           </div>
           <div class="form-group">
               <label for="title" class="col-sm-2 control-label">title:</label>
               <div class="col-sm-10">
                   <input value="${t.title }" type="text" class="form-control" name="title" placeholder="please input title">
               </div>
           </div>
           <div class="form-group">
               <label for="fullTitle" class="col-sm-2 control-label">fulltitle:</label>
               <div class="col-sm-10">
                   <input value="${t.fullTitle }" type="text" class="form-control" name="fullTitle" placeholder="please input fulltitle">
               </div>
           </div>
           <div class="form-group">
               <label for="introduction" class="col-sm-2 control-label">introduction:</label>
               <div class="col-sm-10">
                   <textarea class="form-control" name="introduction" placeholder="please input introduction">${t.introduction }</textarea>
               </div>
           </div>
           <div class="form-group">
               <label for="summary" class="col-sm-2 control-label">summary:</label>
               <div class="col-sm-10">
                   <textarea class="form-control" name="summary" placeholder="please input summary">${t.summary }</textarea>
               </div>
           </div>
           <div class="form-group">
               <label for="story" class="col-sm-2 control-label">story:</label>
               <div class="col-sm-10">
                   <textarea class="form-control" name="story" placeholder="please input story">${t.story }</textarea>
               </div>
           </div>
           <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
           <button type="submit" class="btn btn-default">提交</button>
        </div>
     </div>
    </form>
</my:admin>
	