<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>

<my:admin lang="${lang }">
<form role="form" class="form-horizontal" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="media" class="col-sm-2 control-label"><img src="${t.img }"></label>
                        <div class="col-sm-10">
                            <input type="file" class="form-control" name="media">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="title" class="col-sm-2 control-label">title:</label>
                        <div class="col-sm-10">
                            <input value="${t.title }" type="text" class="form-control" name="title" placeholder="please input title">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="date" class="col-sm-2 control-label">date:</label>
                        <div class="col-sm-10">
                            <input value="${t.date }" type="date" class="form-control" name="date" placeholder="please input date">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="priority" class="col-sm-2 control-label">priority:</label>
                        <div class="col-sm-10">
                            <input value="${t.priority }" type="number" class="form-control" name="priority" placeholder="please input priority">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="author" class="col-sm-2 control-label">author:</label>
                        <div class="col-sm-10">
                            <input value="${t.author }" type="text" class="form-control" name="author" placeholder="please input author">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="origion" class="col-sm-2 control-label">origion:</label>
                        <div class="col-sm-10">
                            <input value="${t.origion }" type="text" class="form-control" name="origion" placeholder="please input origion">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="link" class="col-sm-2 control-label">link:</label>
                        <div class="col-sm-10">
                            <input value="${t.link }" type="url" class="form-control" name="link" placeholder="please input link">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="linkShorthand" class="col-sm-2 control-label">linkShorthand:</label>
                        <div class="col-sm-10">
                            <input value="${t.linkShorthand }" type="text" class="form-control" name="linkShorthand" placeholder="please input linkShorthand">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="summary" class="col-sm-2 control-label">summary:</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" name="summary" placeholder="please input summary">${t.summary }</textarea>
                        </div>
                    </div>
                    <div class="form-group">
				        <div class="col-sm-offset-2 col-sm-10">
				           <button type="submit" class="btn btn-default">提交</button>
				        </div>
				     </div>
                </form>
</my:admin>
			
