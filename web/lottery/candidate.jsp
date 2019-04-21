<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>姓名抽奖</title>
<link rel="stylesheet" type="text/css" href="../css/candidate.css">
<link rel="stylesheet" href="../css/my.css"/>
</head>

<body class="demo2">
<!-- L K -->
<div class="bg">
	<img src="../images/bg.png">
</div>

<div class="box">
	<div class="jz">
		<p><img alt="" onclick="a()"><b>抽奖</b></p>
		<span class="name">姓名</span><br />
		<span class="phone">学号</span><br />
		<div class="start" id="btntxt" onclick="start()">开始</div>
	</div>
	
	<div class="zjmd">
		<div class="top"> </div>
		<div class="list">
			
		</div>
	</div>
</div>

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/covervid.js"></script>
<script type="text/javascript" src="../js/cj.js"></script>
</body>
</html>