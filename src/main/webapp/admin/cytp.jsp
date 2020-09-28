<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getContextPath()%>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/index.css" />
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		function checknull() {
			var check = document.getElementsByName("chbox");
			var radio = document.getElementsByName("radio");
			var count = 0;
			if (radio.length != 0) {
				for (var i = 0; i < radio.length; i++) {
					if(radio[i].checked==true){
						count++;
					}

				}
				if(count==0){
					alert("请先选择选项");
					return false;
				}
			}else {


				for (var i = 0; i < check.length; i++) {
					if(check[i].checked==true){
						count++;
					}

				}
				if(count==0){
					alert("请先选择选项");
					return false;
				}
			}

			const id = $("#id").val();
			const title = $("#title").val();
			const type = $("#typ").val();

			let data;
			let options = []

			let map = new Map()

			if (type == 0){
				let option=$("input[name=radio]:checked").val()
				map.set("id",id)
				map.set("title",title)
				map.set("type",type)
				map.set("radio",option)

				var obj = Object.create(null)
				for(var [k,v] of map){
					obj[k] = v
				}
			}else{
				$("input[name='chbox']").each(function(){
					options.push($(this).val());
				})
				map.set("id",id)
				map.set("title",title)
				map.set("type",type)
				map.set("chbox",options)
				var obj = Object.create(null)
				for(var [k,v] of map){
					obj[k] = v
				}
			}

			$.ajax({
				url: '${pageContext.request.contextPath}/addVote',
				type: 'post',
				// 设置的是请求参数
				data: JSON.stringify(obj),
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

						parent.location.href = 'admin/index.jsp';
						// setTimeout("window.location.reload()", 2000)
					}else if (res.code == 400){
						alert(res.msg);
					}
				}
			})


		}
	</script>

</head>
<body>
	<form onsubmit="return checknull();">
		<table class="table3">
			<input type="hidden" id="id" name="id" value="${id}">
			<input type="hidden" id="title" name="title" value="${title}">
			<input type="hidden" id="typ" name="typ" value="${type}">
			<tr>
				<td class="d1" colspan="2"><img src="img/title_ico.gif"
					style="vertical-align: middle" />&nbsp;&nbsp;参与投票</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="line3"></div>
					<p class="p11">
						<img src="img/vote_icon.gif" /> ${requestScope.title}
					</p> <span class="p2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共有
						${requestScope.optionNum} 个选项，已有 ${requestScope.voteNum} 个网友参与了投票。</span>
				</td>
			</tr>
			<c:forEach var="option" items="${optionList}">
				<%!int count = 1;%>
				<tr>
					<td width="40px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${count}</td>
					<td><c:choose>
							<c:when test="${type==1 }">
								<input type="checkbox" name="chbox" class="bb" value="${option}" />
							</c:when>
							<c:otherwise>
								<input type="radio" name="radio" class="bb" value="${option}" />
							</c:otherwise>
						</c:choose> <label>${option}</label>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td><input type="image" src="img/button_vote.gif" />
					</td>
			</tr>
		</table>
	</form>
</body>
</html>
