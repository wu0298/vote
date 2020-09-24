<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=request.getContextPath() %>/">
<title></title>
		<link rel="stylesheet" href="css/reg.css" />
<%--		<script type="text/javascript" src="js/jquery-1.x.js"></script>--%>
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	</head>
	<body>
		<div class="third">
				<div class="head">添加新投票</div>
				<form onsubmit="return check()">
					<table style="width: 480px">
						<tr>
							<td>投票内容：</td>
							<td><input type="text" id="title" name="title" class="bb" /></td>
						</tr>
						<tr>
							<td>投票类型：</td>
							<td align="left">
								<input type="radio" name="typ" value="1" checked="checked">单选
								<input type="radio" name="typ" value="2">多选
							</td>
						</tr>
						<tbody id="addTr">
						<tr>
							<td>投票选项：</td>
							<td><input type="text" name="option" class="bb"/></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="text" name="option" class="bb"/></td>
						</tr>
						</tbody>
						<tr>
							<td></td>
							<td align="left">
								<input type="image" src="img/button_submit.gif" style="vertical-align:middle" />
								&nbsp;&nbsp;&nbsp;
								<a  id="getStr">增加选项</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="admin/tpList.jsp">取消操作</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div class="bottom"></div>
	</body>
<script>

	function check() {
		var count = 0;
		$(".bb").each(function () {
			if ($(this).val() == '') {
				count++;
			}
		})
		if (count > 0) {
			alert("表单有内容为空");
			return false;
		}


		var c = document.getElementsByName("option");
		var b, i, j;
		for (i = 0; i < c.length; i++) {
			b = c[i].value;
			for (j = i + 1; j < c.length; j++) {
				if (b == c[j].value) {
					alert("有相同选项");
					return false;
				}
			}
		}

		const title = $('#title').val();
		const typ = $('input[name="typ"]:checked').val();
		let option =[];
		$("input[name='option']").each(function(){
			option.push($(this).val());
		})
		// option = JSON.stringify(option)
		var data = {"title":title,"typ":typ,"option":option}
		data = JSON.stringify(data)
		console.log(data)



		$.ajax({
			url: '${pageContext.request.contextPath}/addArticle',
			type: 'post',
			// 设置的是请求参数
			data: data,
			async: false,
			// 用于设置响应体的类型 注意 跟 data 参数没关系！！！
			contentType: "application/json",//如果想以json格式把数据提交到后台的话，这个必须有，否则只会当做表单提交
			dataType: 'json',
			success: function (res) {
				// 一旦设置的 dataType 选项，就不再关心 服务端 响应的 Content-Type 了
				// 客户端会主观认为服务端返回的就是 JSON 格式的字符串
				// console.log(res);
				if(res.code ==200){
					alert(res.msg);
					window.location.reload();
					// setTimeout("window.location.reload()", 2000)
				}else if (res.code == 400){
					alert(res.msg);
				}
			}
		})
	}
</script>
</html>