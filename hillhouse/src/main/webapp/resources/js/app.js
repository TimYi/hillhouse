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