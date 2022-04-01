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




	<h2 align = "left">●お問い合わせフォーム</h2>

		<table align="right">
			<tr>
				<td width="1500">&nbsp;</td>
				<td width="1500">&nbsp;</td>
			</tr>
		</table>




		<table class="detail-table">
			<tr>
				<td>名前</td>
				<td><input type="text" value=""	><font size="2" color="red">※必須</font></td>
			</tr>
			<tr>
				<td>メールアドレス</td>
				<td><input type="text" value=""	><font size="2" color="red">※必須</font></td>
			</tr>
			<tr>
				<td>電話番号</td>
				<td><input type="text" value=""	><font size="2" color="red">※必須</font></td>
			</tr>
			<tr>
				<td>お問い合わせ項目</td>
				<td>
					<select name="menu" >
						<option value="">料金・お支払いについて</option>
						<option value="">講座、コース、教材について</option>
						<option value="">学習の進め方について</option>
						<option value="">学習期限</option>
						<option value="">受講終了後のサポ－トについて</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>お問い合わせ内容</td>
				<td><textarea rows="5" cols="50"></textarea>
			</tr>
			<tr>
				<td width="200">&nbsp;</td>
				<td align="right"><input type ="submit" value="送信"></td>
			</tr>

		</table>



	</body>
</html>