$(function(){
	$("textarea").each(function(){
		var uuid=generateUUID();
		$(this).attr("id",uuid);
		KindEditor.ready(function(K) {
            window.editor = K.create('#'+uuid);
		});
	});
});


//查看已有资源
function info(url,id) {
    window.location.href=url+"/"+id;
}
//修改已有资源
function edit(url,id) {
    window.location.href=url+"/"+id+"/edit";
}
//新增资源
function add(url) {
    window.location.href=url+"/add";
}
function del(url,id) {
    $.ajax({
        url:url+"/"+id,
        type:"POST",
        success:function() {
            $("#"+id).remove();
        },
        error:function() {
            alert("删除失败！");
        }
    });
}
function deploy(url) {
	$.ajax({
        url:url,
        type:"POST",
        success:function() {
            alert("发布成功");
        },
        error:function() {
            alert("发布失败！");
        }
    });
}

function generateUUID() {
    var d = new Date().getTime();
    var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = (d + Math.random()*16)%16 | 0;
        d = Math.floor(d/16);
        return (c=='x' ? r : (r&0x3|0x8)).toString(16);
    });
    return uuid;
};