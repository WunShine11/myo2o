layui.use(['form','layer','jquery'],function(){

    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;

    $(".loginBody .seraph").click(function(){
        layer.msg("这只是做个样式，至于功能，你见过哪个后台能这样登录的？还是老老实实的找管理员去注册吧",{
            time:5000
        });
    })

    //登录按钮
    //var context = [[@{/}]];=
   /* form.on("submit(login)",function(data){


        $(this).text("登录中...").attr("disabled","disabled").addClass("layui-disabled");
        setTimeout(function(){

            window.location.href = "";
        },1000);
        return false;
    })
*/
    $("#changeCode").click(function () {
        $(this).attr("src","/o2o/code/kaptcha?p"+new Date())
    })

    $("#userName").blur(function(){

        var name = this.val();
        //2. 发送请求
        $.post("/auth/checkName" , this.val() , function(data){
            //alert(data);
            if(data == 1){//用户名存在
                alert("用户名存在");
                //$("#span01").html("<font color='red'>用户名已被注册</font>");
            }else{
                alert("用户名可用");
                //$("#span01").html("<font color='green'>用户名可以使用</font>");
            }
        } );
    })
    //表单输入效果
    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() != ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    })
})
