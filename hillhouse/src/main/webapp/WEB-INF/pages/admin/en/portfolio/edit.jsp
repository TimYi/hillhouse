<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
			<form role="form" class="form-horizontal" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="media" class="col-sm-2 control-label"><img src="${t.url }"></label>
                        <div class="col-sm-10">
                            <input type="file" class="form-control" name="media">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">name:</label>
                        <div class="col-sm-10">
                            <input value="${t.name }" type="text" class="form-control" name="name" placeholder="please input name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="link" class="col-sm-2 control-label">link:</label>
                        <div class="col-sm-10">
                            <input value="${t.link }" type="url" class="form-control" name="link" placeholder="please input link">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="priority" class="col-sm-2 control-label">priority:</label>
                        <div class="col-sm-10">
                            <input value="${t.priority }" type="number" class="form-control" name="priority" placeholder="please input title">
                        </div>
                    </div>
                    <div class="form-group">
				        <div class="col-sm-offset-2 col-sm-10">
				           <button type="submit" class="btn btn-default">提交</button>
				        </div>
				     </div>
                </form>
<%@ include file="../footer.jsp" %>