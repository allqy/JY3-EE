window.onload=function () {
    $("#updateBtn").click(function () {
        var firPwd=$("#inputPassword3").val();
        //console.log(firPwd);
        var secPwd=$("#inputPassword4").val();
        //console.log(secPwd);
        if (firPwd !== secPwd) {
            alert("两次输入密码不一致!");
        }
    })
}