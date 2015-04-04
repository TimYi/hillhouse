
function contact() {
    toggle(".contact");
    var rowpos = $('#contact').position();
    $('body').scrollTop(rowpos.top);
}
function home() {
    toggle("#hm-slide");
    toggle("#hm");
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