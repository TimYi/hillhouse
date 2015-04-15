
$(function(){	
    if($(".hm").size()>0) {
       if(!isFresh()) {
            home();
        }
    }
    //将Contact表单改为ajax提交
    $("#contact").submit(function(e) {        
        var form=$(this);
        var url=form.attr("action");
        $.ajax({
               type: "POST",
               url: url,
               data: form.serialize(), // serializes the form's elements.
               success: function(data) {
                   contact();
               },
                error: function() {
                    contact();
                    throw "错误！";
                }
             });

        e.preventDefault();
        return false;
    });
});

function contact() {
    toggle(".contact");
    var rowpos = $('#contact').position();
    $(document).scrollTop(rowpos.top);
}

function home() {
    toggle("#hm-slide");
    toggle("#body");
}

function isFresh() {
    if($.cookie("login")==null) {
        $.cookie("login","y");
        return true;
    }
    return false;
}
/**========================
*toggle函数，执行展开收起逻辑
*area：要展开收起的区域
*options.display：展开后的display样式
*options.type：toggle, hide, show三种
=========================*/
function toggle(area,options) { 
    options=options?options:{};
    var display=options.display?options.display:"block";
    var type=options.type?options.type:"toggle";
    area=$(area);
    switch(type) {
        case "hide":
            if(area.css("display")!="none") {
                area.css("display","none");
            }
            break;
        case "show":
            if(area.css("display")=="none") {
                area.css("display",display);
            }
            break;  
        default:
            display=(area.css("display")=="none")?display:"none";
            area.css("display",display);
    }        
}

/**========================
*toggle函数，注册toggle监听事件
*area：要展开收起的区域
*area href=""指向点击区域
*options：toggle函数用到的选项
=========================*/
function startToggle(area,options) {
    if(typeof(area)=="string") {
        $(area).each(function(){
            startToggle(this);
        });
    }else {
        var href=$(area).attr("href");
        $(href).click(function(event){
            toggle(area,options);           
        });
    }
}