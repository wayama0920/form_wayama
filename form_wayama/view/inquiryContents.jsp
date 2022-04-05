<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.InquiryInfo"%>

<%
InquiryInfo inquiry = (InquiryInfo)request.getAttribute("inquiry");
String error = (String)request.getAttribute("error");
%>

<html>
<head>
<title>問い合わせ詳細</title>
</head>
<body>
	<header>
		<h1>神田英会話スクール</h1>
	</header>

	<hr align="center" size="2" color="black" width="auto">

	<h2 align="left">問い合わせ詳細</h2>

	<%
  if(inquiry != null){
  %>

	<form action="<%=request.getContextPath()%>/inquiryReply">
	<table align="center">
		<tr>
			<td bgcolor="#6666ff" width="200">氏名</td>
			<td style="text-align: center; width: 100"><%= inquiry.getName() %></td>
		</tr>
		<tr>
			<td bgcolor="#6666ff" width="200">電話番号</td>
			<td style="text-align: center; width: 100"><%= inquiry.getNumber() %></td>
		</tr>
		<tr>
			<td bgcolor="#6666ff" width="200">メールアドレス</td>
			<td style="text-align: center; width: 100"><%= inquiry.getEmail() %></td>
		</tr>
		<tr>
			<td bgcolor="#6666ff" width="200">問い合わせ項目</td>
			<td style="text-align: center; width: 100"><%= inquiry.getSelectmenu() %></td>
		</tr>
		<tr>
			<td bgcolor="#6666ff" width="200">問い合わせ詳細</td>
			<td style="text-align: center; width: 100"><%= inquiry.getText() %></td>
		</tr>
	</table>

	<br>

	<table align="center">
		<tr>
			<td align="center"><input type="submit" value="返信"><input type="hidden" name="inquiryNo" value="<%=inquiry.getInquiryNo() %>"></input></td>
		</tr>
	</table>

	</form>


	<%
}
%>


</body>
</html>
