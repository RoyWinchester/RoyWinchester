<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<!--  Css -->
	<link rel="stylesheet" href="../css/style.css">
	<link rel="stylesheet" href="../css/main_response.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.css">
	<!--  JavaScript -->
	<script src="../js/jquery-2.1.4.min.js"></script>
	<script src="../js/materialize.js"></script>
	<title>拆红包</title>

	<style>
		.ab{position:relative;}
		.ab2{width:300px;
			height:200px;
			position:fixed;
			left:50%;
			top:43%;
			margin:-100px 0 0 -150px }
		body{ background:url("../images/318d0ec5cb1596028e8dba7cebcc9980_1_3_photo.jpg") no-repeat;
			background-size:100% 110%;
			height: 750px;
		}
	</style>

	<script type="text/javascript">
        function randomFrom(lowerValue,upperValue)
        {
            return Math.floor(Math.random() * (upperValue - lowerValue + 1) + lowerValue);
        }
        function money(){
            alert(randomFrom(1,500)+"元人民币！");
        }
	</script>

</head>
<body>
<div class="fixed-action-btn horizontal">
	<a href="../index.jsp" class="btn-floating btn-large red tooltipped" data-position="top" data-delay="50" data-tooltip="回到上一级">
		<i class="large material-icons" >replay</i>
	</a>
</div>

<div class="ab">

	<div class="ab2"><img id="red1" src="../images/red.png" alt="egg1" title="点击拆红包，赢大奖！" onclick="money();"  /></div>

</div>

</body>


</html>