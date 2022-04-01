<%@page contentType="text/html;charset=UTF-8" %>



<html>
	<head>
		<title>ログイン画面</title>
		<link rel ="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	</head>
	<body>
	<header>
		<h1 align = "center">神田英会話スクール</h1>
	</header>





		<hr align="center" size="2" color="black" width="auto">

		<h2 align = "center">●ログイン画面</h2>


		<form action="<%=request.getContextPath()%>/login" method="post">
		<table class="login-table">
			<tr>
				<td >ユーザー</td>
				<td  width="200"><input type="text" name="userid" > </td>
			</tr>
			<tr>
				<td >パスワード</td>
				<td width="200" ><input type="password" name="password" > </td>
			</tr>
		</table>

		<table class="input-table">
			<tr>
				<td>
				<input type ="submit" value="ログイン">
				</td>
			</tr>
		</table>
		</form>

	</body>
</html>