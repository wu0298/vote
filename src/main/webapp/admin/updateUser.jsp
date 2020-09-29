<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="<%=request.getContextPath() %>/">
    <title></title>
    <link rel="stylesheet" href="css/reg.css" />
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="third">
    <div class="head">修改密码</div>
    <form onsubmit="return check()">
        <table style="width: 480px">
            <tr>
                <td>请输入新密码：</td>
                <td>
                    <input type="text" id="password" name="password" class="bb" value=""/>
                </td>
            </tr>
            <tr>
                <td>请确认新密码：</td>
                <td>
                    <input type="text" id="pwd" name="pwd" class="bb" value=""/>
                </td>
            </tr>
        </table>
        <input style="margin-left: 281px;width: 67px" type="submit" value="确  认">
    </form>
</div>
<div class="bottom"></div>
</body>

<script>
    function check() {
        var count = 0;
        $(".bb").each(function() {
            if ($(this).val() == '') {
                count++;
            }
        })
        if (count > 0) {
            alert("表单有内容为空");
            return false;
        }


        const password = $("#password").val();
        const pwd = $("#pwd").val();

        if (password != pwd){
            alert("两次密码不一致！")
            return false;
        }

        var data = {"password":password}

        $.ajax({
            url: '${pageContext.request.contextPath}/updateUser',
            type: 'post',
            // 设置的是请求参数
            data: data,
            async: false,
            // 用于设置响应体的类型 注意 跟 data 参数没关系！！！
            // contentType: "application/json",//如果想以json格式把数据提交到后台的话，这个必须有，否则只会当做表单提交
            dataType: 'json',
            success: function (res) {
                // 一旦设置的 dataType 选项，就不再关心 服务端 响应的 Content-Type 了
                // 客户端会主观认为服务端返回的就是 JSON 格式的字符串
                // console.log(res);
                if(res.code ==200){
                    alert(res.msg);
                    parent.location.href = 'admin/index.jsp';
                    // setTimeout("window.location.reload()", 2000)
                }else if (res.code == 400){
                    alert(res.msg);
                }
            }
        })

    }



</script>
</html>