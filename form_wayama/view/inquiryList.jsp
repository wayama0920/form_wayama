<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.InquiryInfo"%>
<%
ArrayList<InquiryInfo> list =(ArrayList<InquiryInfo>)request.getAttribute("list");

%>
<html>
<head>
<title>管理社画面</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<header>
		<h1>神田英会話スクール</h1>
	</header>

	<hr align="left" size="2" color="black" width="auto">


	<h2 align="left">●お問い合わせ一覧</h2>


	<h3 align="right">
		<a href="<%=request.getContextPath()%>/logout"> ログアウト</a>
	</h3>



	<hr align="left" size="2" color="black" width="auto">
	</td>



	<table align="right">
		<tr>
			<td width="1500">&nbsp;</td>
			<td width="1500">&nbsp;</td>
		</tr>
	</table>

	<table align="left">
		<tr>
			<td bgcolor="#6666ff" width="200">No</td>
			<td bgcolor="#6666ff" width="200">名前</td>
			<td bgcolor="#6666ff" width="200">メールアドレス</td>
			<td bgcolor="#6666ff" width="200">電話番号</td>
			<td bgcolor="#6666ff" width="200">種類</td>
			<td bgcolor="#6666ff" width="200">お問い合わせ日時</td>
			<td bgcolor="#6666ff" width="200">お問い合わせ内容</td>
		</tr>


		<%
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					InquiryInfo inquiryinfo = (InquiryInfo) list.get(i);
		%>

		<tr>
			<td><a href="<%=request.getContextPath() %>/inquiryContents?inquiryNo=<%=inquiryinfo.getInquiryNo()%>"><%=inquiryinfo.getInquiryNo() %></a></td>
			<td><%=inquiryinfo.getName() %></td>
			<td><%=inquiryinfo.getEmail() %></td>
			<td><%=inquiryinfo.getNumber() %></td>
			<td><%=inquiryinfo.getSelectmenu() %></td>
			<td><%=inquiryinfo.getDate() %></td>
			<td><%=inquiryinfo.getText() %></td>
		</tr>


	</table>
	<%
		}
		} else {
	%>
	<tr>
		<td align="center" width="200">&nbsp;</td>
		<td align="center" width="200">&nbsp;</td>
		<td align="center" width="200">&nbsp;</td>
		<td align="center" width="250" colspan="2">&nbsp;</td>
	</tr>
	<%
		}
	%>



</body>
</html>