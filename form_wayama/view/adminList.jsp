<%@page contentType="text/html;charset=UTF-8" %>

<html>
	<head>
		<title>管理社画面</title>
		<link rel ="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	</head>
	<body>
	<header>
		<h1>神田英会話スクール</h1>
	</header>

	<hr align="left" size="2" color="black" width="auto">


	<h2 align = "left">●お問い合わせ一覧</h2>


	<h3 align="right">
		<a  href="<%=request.getContextPath()%>/view/login.jsp">  ログイン画面</a>
	</h3>



	<hr align="left" size="2" color="black" width="auto"></td>



		<table align="right">
			<tr>
				<td width="1500">&nbsp;</td>
				<td width="1500">&nbsp;</td>
			</tr>
		</table>





		<table align="left">
			<tr>
				<td bgcolor="#6666ff" width="200" >No</td>
				<td bgcolor="#6666ff" width="200" >名前</td>
				<td bgcolor="#6666ff" width="200" >メールアドレス</td>
				<td bgcolor="#6666ff" width="200" >電話番号</td>
				<td bgcolor="#6666ff" width="200" >種類</td>
				<td bgcolor="#6666ff" width="200" >お問い合わせ日時</td>
				<td bgcolor="#6666ff" width="200" >お問い合わせ内容</td>
			</tr>
			<tr>
				<td>1</td>
				<td>佐藤</td>
				<td>XXXXX@gmail.com</td>
				<td>080-XXXX-XXXX</td>
				<td>料金・支払い</td>
				<td>XX時XX分</td>
				<td>すみません。</td>
			</tr>

		</table>



	</body>
</html>