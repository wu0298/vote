<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=request.getContextPath()%>/">
<title></title>
		<link rel="stylesheet" href="css/index.css" />
	</head>
	<body>
		<div class="main">
			<table class="table2">
				<tr>
					<td class="d1" colspan="2"><img src="img/title_ico.gif" style="vertical-align:middle" />&nbsp;&nbsp;投票列表</td>
				</tr>
		
				<c:forEach var="listing" items="${list}">
				<tr>
					<td width="810px">
						<span class="p1"><img src="img/vote_icon.gif" /> <a href="lookVote?title=${listing.title}&id=${listing.id}&optionNum=${listing.optionNum}&voteNum=${listing.voteNum}" id="h1">${listing.title }</a></span><br>
						<span class="p2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共有 ${listing.optionNum}个选项，已有${listing.voteNum }个网友参与了投票。</span>
					</td>
					<td width="180px">
						<img src="img/join.gif" /> 
						<c:choose>
						<c:when test="${sessionScope.del=='d'}">
							<a href="delVote?id=${listing.id}" onclick="return confirm('是否确认删除?')">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%--							<a href="updateOption?id=${listing.id}&title=${listing.title}">查看</a>--%>
						</c:when>
						<c:when test="${listing.vote==true }">
							<a href="lookVote?title=${listing.title}&id=${listing.id}&optionNum=${listing.optionNum}&voteNum=${listing.voteNum}" class="p3" target="mainframe">已投票</a>
						</c:when>
						<c:otherwise>
							<a href="selectVote?id=${listing.id}&title=${listing.title}&optionNum=${listing.optionNum}&voteNum=${listing.voteNum}" class="p3" target="mainframe">我要参与</a>
						</c:otherwise>
						</c:choose>
						
					</td>
				</tr>
				
				</c:forEach>
				<tr>
				<td style="padding-left: 400px"><a href="${pageContext.request.contextPath}/loadArticleList?title=${title}&page=${page-1}&del=${del}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/loadArticleList?title=${title}&page=${page+1}&del=${del}">下一页</a></td>
				<tr>
			</table>
		</div>
	</body>
<style>
</style>
</html>
