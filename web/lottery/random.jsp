<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
    <!--  CSS -->
    <link rel="stylesheet" href="../css/random.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.css">
    <!--  JavaScript -->
    <script src="../js/jquery-2.1.4.min.js"></script>
    <script src="../js/materialize.js"></script>
<title>随机数抽奖</title>
</head>
<div class="fixed-action-btn horizontal">
    <a href="../index.jsp" class="btn-floating btn-large red tooltipped" data-position="top" data-delay="50" data-tooltip="回到上一级">
        <i class="large material-icons" >replay</i>
    </a>
</div>
<body>
<div class="operator-box">
<div class="flex-box">
	<div class="input-box" id="start">
			<input type="text" placeholder="输入“开始”后回车！" id="input-text">
			<p>（滑动右方已出现的数字可以删除）</p>
	 </div>    
</div>


</div>
<script src="../js/random.min.js"></script>
<script src="../js/random.js"></script>
<script>
var iCircle = new Circle();
</script>


</body>
</html>
