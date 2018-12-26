<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>

<title>Admin画面</title>

<style type="text/css">
	body{
			background-color:black;
			color:white;
	}

	#header{
			width:100%;
			text-align:center;
			height:100px;
			line-height:100px;

}

	#inner{
			display:inline-block;
			padding:10px;
			height:40px;
			line-height:10px;
			border:solid 3px white;
			/* background-color:red; */
			color:yellow;
	}

	#left{
			width:50%;
			float:left;
			text-align:center;
	}

	#right{
			width:50%;
			float:left;
			text-align:center;
	}

	#l_box{
			clear:left;
			display:inline-block;
			width:250px;
			height:200px;
			border:solid 1px white;
			text-align:center;
	}


	#r_box{
			display:inline-block;
			width:250px;
			height:200px;
			border:solid 1px white;
			text-align:center;
	}

	#button{
			height:50px;
			font-size:30px;
	}

	#top{
			text-align:center;
	}

	input[type="submit"]{
	width:120px;
	height:2000px;
	font-size:100px;
	text-align:center;
	}


</style>
</head>
<body>
	<div id=header>
		<div id=inner>
				<h2>管理者画面</h2>
		</div>
	</div>
	<div id=main>
		<div id=top>
			<div id=left>
				<h3>商品</h3>
				<div id=l_box>
					<s:form action="ItemCreateAction">
						<s:submit value="新規登録" />
					</s:form>
					<s:form action="ItemListAction">
						<s:submit value="一覧"/>
					</s:form>
				</div>
			</div>
			<div id=right>
				<h3>ユーザー</h3>
				<div id=r_box>
					<s:form action="UserCreateAction">
						<s:submit value="新規登録"/>
					</s:form>
					<s:form action="UserListAction">
						<s:submit value="一覧" />
					</s:form>
				</div>
			</div>
			<div id="text-link">
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>


</body>
</html>