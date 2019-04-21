<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta charset="utf-8">
	<title>欢迎你，请注册！</title>
	<link href="../css/register.css" rel="stylesheet" type="text/css">
	<script src="../js/jquery.min.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="../css/home/iconfont.css">
	<meta name="keywords" content=""/>
	<style>
		img { border:0px; vertical-align:middle; padding:0px; margin:0px; }
		input, button { font-family:"Arial", "Tahoma", "微软雅黑", "雅黑"; border:0;
			vertical-align:middle; margin:8px; line-height:18px; font-size:18px }
		.btns { width:143px; height:40px; background:url("../images/2.jpg") no-repeat center ; color:#FFF; }
	</style>
	<style>
		.button4 {
			background-color: rgba(51,153,255);
			border: none;
			color: white;
			padding: 15px 20px;
			text-align: left;
			text-decoration: none;
			display: inline-block;
			font-size: 16px;
			margin: 4px 2px;
			cursor: pointer;
			border-radius: 15px;
		}
		.button4:hover{
			background-color:rgba(102,160,160);
			color: white;
		}
	</style>
	<script>
        // 在这里写js
        function fnLogin() {
            var oUname = document.getElementById("username");
            var oUpass = document.getElementById("password");

            if (oUname.value.length > 20 || oUname.value.length < 6) {
                alert("用户名请输入6-20位字符");
                return false;
            }else if((oUname.value.charCodeAt(0)>=48) && (oUname.value.charCodeAt(0)<=57)){
                alert("用户名首字符必须为字母");
                return false;
            }else for(var i=0;i<oUname.value.charCodeAt(i);i++){
                if((oUname.value.charCodeAt(i)<48)||(oUname.value.charCodeAt(i)>57) && (oUname.value.charCodeAt(i)<97)||(oUname.value.charCodeAt(i)>122)){
                    alert("用户名必须为字母跟数字组成");
                    return false;
                }
            }
            if (oUpass.value.length > 20 || oUpass.value.length < 6) {
                alert("密码请输入6-20位字符");
                isError = false;
                return false;
            }

            window.alert("注册成功");
            return true;
        }

	</script>
</head>
<body>
<div class="header" id="demo">
	<div class="canvaszz"> </div>
	<canvas id="canvas"></canvas>
	<div class="row1" id="container" align="center">
		<div class="nav1">
			<a class="gv" href="register.jsp">注册</a>
			<a class="gv" href="login.jsp">登录</a>

			<form action="../servlet/RegisterServlet"  method="post">
				<div class="logo_box1">
					<div id="content">
						<div class="input_outer">
							<span class="u_user"></span>
							<input placeholder="以字母开头的不少于6位的字符" class="text" style="color: #FFFFFF !important;position:absolute; z-index:100;"
								   value="" id="username" name="username" class="user" type="text" required="">
						</div>
						<br>
						<div class="input_outer" >
							<span class="us_uer" ></span>
							<input placeholder="请输入6-20位字符密码" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"
								   value="" id="password" name="password" type="password" required="">
						</div><br>

						<div class="wthree-text">
							<ul>
								<label class="anim">
									<input type="checkbox" class="checkbox" required="">
									<span style="color:#FFFFFF">我已阅读并同意《***》</span>
								</label>
								<br>

							</ul>
						</div>
						<div id="error_box"></div>
					</div>
					<input onclick="return(fnLogin())" type="submit" class="btns" onmouseover="this.style.backgroundPosition='left -40px'"
						   onmouseout="this.style.backgroundPosition='center'"  value="注册">

				</div>
			</form>
			<div class="home">
				<a class="waves-effect waves-light button4" href="../index.jsp"><i class="iconfont">&#xe65b;</i></a>
			</div>
		</div>
	</div>

	<button class="btn waves-effect waves-light" type="submit" name="action">提交
		<i class="material-icons right">send</i>
	</button>

</div>
<script>
    //宇宙特效
    "use strict";
    var canvas = document.getElementById('canvas'),
        ctx = canvas.getContext('2d'),
        w = canvas.width = window.innerWidth,
        h = canvas.height = window.innerHeight,

        hue = 217,
        stars = [],
        count = 0,
        maxStars = 1300;//星星数量

    var canvas2 = document.createElement('canvas'),
        ctx2 = canvas2.getContext('2d');
    canvas2.width = 100;
    canvas2.height = 100;
    var half = canvas2.width / 2,
        gradient2 = ctx2.createRadialGradient(half, half, 0, half, half, half);
    gradient2.addColorStop(0.025, '#CCC');
    gradient2.addColorStop(0.1, 'hsl(' + hue + ', 61%, 33%)');
    gradient2.addColorStop(0.25, 'hsl(' + hue + ', 64%, 6%)');
    gradient2.addColorStop(1, 'transparent');

    ctx2.fillStyle = gradient2;
    ctx2.beginPath();
    ctx2.arc(half, half, half, 0, Math.PI * 2);
    ctx2.fill();

    // End cache

    function random(min, max) {
        if (arguments.length < 2) {
            max = min;
            min = 0;
        }

        if (min > max) {
            var hold = max;
            max = min;
            min = hold;
        }

        return Math.floor(Math.random() * (max - min + 1)) + min;
    }

    function maxOrbit(x, y) {
        var max = Math.max(x, y),
            diameter = Math.round(Math.sqrt(max * max + max * max));
        return diameter / 2;
        //星星移动范围，值越大范围越小，
    }

    var Star = function() {

        this.orbitRadius = random(maxOrbit(w, h));
        this.radius = random(60, this.orbitRadius) / 8;
        //星星大小
        this.orbitX = w / 2;
        this.orbitY = h / 2;
        this.timePassed = random(0, maxStars);
        this.speed = random(this.orbitRadius) / 50000;
        //星星移动速度
        this.alpha = random(2, 10) / 10;

        count++;
        stars[count] = this;
    }

    Star.prototype.draw = function() {
        var x = Math.sin(this.timePassed) * this.orbitRadius + this.orbitX,
            y = Math.cos(this.timePassed) * this.orbitRadius + this.orbitY,
            twinkle = random(10);

        if (twinkle === 1 && this.alpha > 0) {
            this.alpha -= 0.05;
        } else if (twinkle === 2 && this.alpha < 1) {
            this.alpha += 0.05;
        }

        ctx.globalAlpha = this.alpha;
        ctx.drawImage(canvas2, x - this.radius / 2, y - this.radius / 2, this.radius, this.radius);
        this.timePassed += this.speed;
    }

    for (var i = 0; i < maxStars; i++) {
        new Star();
    }

    function animation() {
        ctx.globalCompositeOperation = 'source-over';
        ctx.globalAlpha = 0.5; //尾巴
        ctx.fillStyle = 'hsla(' + hue + ', 64%, 6%, 2)';
        ctx.fillRect(0, 0, w, h)

        ctx.globalCompositeOperation = 'lighter';
        for (var i = 1, l = stars.length; i < l; i++) {
            stars[i].draw();
        };

        window.requestAnimationFrame(animation);
    }

    animation();
</script>
</body>