<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
			<form role="form" class="form-horizontal" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="media" class="col-sm-2 control-label">image:</label>
                        <div class="col-sm-10">
                            <input type="file" class="form-control" name="media">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="firstname" class="col-sm-2 control-label">firstname:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="firstname" placeholder="please input firstname">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">lastname:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="lastname" placeholder="please input lastname">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="priority" class="col-sm-2 control-label">priority:</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" name="priority" placeholder="please input title">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="title" class="col-sm-2 control-label">title:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="title" placeholder="please input title">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fullTitle" class="col-sm-2 control-label">fulltitle:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="fullTitle" placeholder="please input fulltitle">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="summary" class="col-sm-2 control-label">summary:</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" name="summary" placeholder="please input summary"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="story" class="col-sm-2 control-label">story:</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" name="story" placeholder="please input story"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
				        <div class="col-sm-offset-2 col-sm-10">
				           <button type="submit" class="btn btn-default">提交</button>
				        </div>
				     </div>
                </form>
<%@ include file="../footer.jsp" %>