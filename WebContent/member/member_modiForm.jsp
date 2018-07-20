<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>휘원정보 수정</title>
<style>
	#memberInfoArea{
		width : 400px;
		margin : auto;
		border : 1px solid gray;
	}
	table{
		width : 380px;
		margin : auto;
		text-align: center;
	}
</style>
</head>
<body>

<section id = "memberInfoArea">
<form action = "memberModiAction.me?id=${member.MEMBER_ID }" method = "post">
<table>
	<tr>
		<td colspan="2">
			<h1>회원정보 수정</h1>
		</td>
	</tr>
	<tr>
		<td><label for = "MEMBER_ID">아이디 : </label> </td>
		<td><input type="hidden" name="MEMBER_ID" id = "MEMBER_ID" value="${member.MEMBER_ID }"/>${member.MEMBER_ID}</td>
	</tr>
	<tr>
		<td><label for = "MEMBER_PW">비밀번호 : </label></td>
		<td><input type="password" name="MEMBER_PW" id = "MEMBER_PW" value="${member.MEMBER_PW }"/></td>
	</tr>
	<tr>
		<td><label for = "MEMBER_NAME">이름 : </label></td>
		<td><input type="text" name="MEMBER_NAME" id = "MEMBER_NAME" value="${member.MEMBER_NAME }"/></td>
	</tr>
	<tr>
		<td><label for = "MEMBER_AGE">나이 : </label></td>
		<td><input type="text" name="MEMBER_AGE" maxlength="2" id = "MEMBER_AGE" value="${member.MEMBER_AGE }"/></td>
	</tr>
	<tr>
		<td><label for = "MEMBER_GENDER">성별 : </label></td>
		<td>
			<input type="radio" name="MEMBER_GENDER" value="남" checked="checked" id = "MEMBER_GENDER"/>남자
			<input type="radio" name="MEMBER_GENDER" value="여"/>여자
		</td>
	</tr>
	<tr>
		<td><label for = "MEMBER_EMAIL">이메일 주소 : </label></td>
		<td><input type="text" name="MEMBER_EMAIL" id = "MEMBER_EMAIL" value="${member.MEMBER_EMAIL }"/></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="수정"></input>
		</td>
	</tr>
</table>
</form>
</section>
</body>
</html>