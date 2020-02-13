window.onload = function(){
    //分析cookie值，显示上次的登陆信息
    var userNameValue = $.cookie("username");
    $("#username").val(userNameValue);
    var passwordValue = $.cookie("password");
    $("#password").val(passwordValue);
    //写入点击事件
    $("submitForm").onclick = function()
    {
        var userNameValue = $("#username").val();
        var passwordValue = $("#password").val();
        var r=document.getElementsByName("rememberMe");
        if(r[0].checked) {
            var username = $("#username").val();
            var password = $("#password").val();
            $.cookie("username",username);
            $.cookie("password",password);
        }
    }
}