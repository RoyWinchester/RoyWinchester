<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<!--  Css -->
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/main_response.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.css">
	<!--  JavaScript -->
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/materialize.js"></script>
	<title>砸金蛋</title>
</head>
<div class="fixed-action-btn horizontal">
    <a href="index.jsp" class="btn-floating btn-large red tooltipped" data-position="top" data-delay="50" data-tooltip="回到上一级">
        <i class="large material-icons" >replay</i>
    </a>
</div>
<body>
	<div class="goldContent">
		<div class="goldEggsDiv">
			<img class="centerPage_Img" src="images/universe.png" alt="砸金蛋" title="砸金蛋">
			<div class="list_EggsDiv"  id="carousel">
				<div>
					<ul class="jinDanUl" id="jinDanUl1">
						<li><img src="images/egg.png" alt="egg1" title="快来砸我呀！"/></li>
						<li><img src="images/egg.png" alt="egg2" title="快来砸我呀！"/></li>
						<li><img src="images/egg.png" alt="egg3" title="快来砸我呀！"/></li>
					</ul>	
				</div>
				<div>
					<ul class="jinDanUl1" id="jinDanUl2">
						<li><img src="images/egg.png" alt="egg4" title="快来砸我呀！"/></li>
						<li><img src="images/egg.png" alt="egg5" title="快来砸我呀！"/></li>
						<li><img src="images/egg.png" alt="egg6" title="快来砸我呀！"/></li>
					</ul>	
				</div>
			</div>
		</div>
	</div>
</body>
<script data-main="js/domain.js" src="js/jquery-2.1.0.min.js"></script>
<script src="js/require.js"></script>


</html>