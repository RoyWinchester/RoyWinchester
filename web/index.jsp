<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="renderer" content="webkit">
    <!--  CSS -->

    <link type="text/css" href="./css/index.css"  rel="stylesheet" >
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.css">
    <!--  JavaScript -->
    <script src="js/jquery-2.1.4.min.js"></script>
    <script src="js/materialize.js"></script>
    <script>M.AutoInit();</script>
    <title>抽奖</title>
</head>
<body>
    <div class="universe">
        <div class="solarsystem">
            <!--太阳 管理员-->
            <%! String ls; %>
            <%
                if(session.getAttribute("isLogin")!=null) {
                    if((Boolean)session.getAttribute("isLogin"))
                        ls="lottery/admin.jsp";
                }
                else
                        ls="lottery/login.jsp";
                System.out.println(ls);
            %>

            <div class="hoverable circle sun tooltipped" data-position="top" data-delay="50" data-tooltip="管理员登陆"
                 onclick="window.location='<%=ls %>'">
            </div>
            <!--水星 太小-->
            <div class="orbit mercury">
                <div class="planet">
                    <div class="hoverable circle ball"></div>
                </div>
            </div>
            <!--金星 太小-->
            <div class="orbit venus">
                <div class="planet">
                    <div class="hoverable circle ball"></div>
                </div>
            </div>
            <!--地球 太小-->
            <div class="orbit earth" onclick="window.location='lottery/redpacket.jsp'">
                <div class="planet">
                    <div class="hoverable circle ball tooltipped" data-position="bottom" data-delay="50" data-tooltip="拆红包" ></div>
                </div>
            </div>
            <!--火星 候选人抽奖-->
            <div class="orbit mars" onclick="window.location='lottery/candidate.jsp'">
                <div class="planet">
                    <div class="hoverable circle ball tooltipped" data-position="bottom" data-delay="50" data-tooltip="候选人抽奖"></div>
                </div>
            </div>
            <!--木星 canvas随机数-->
            <div class="orbit jupiter" onclick="window.location='lottery/random.jsp'">
                <div class="planet">
                    <div class="hoverable circle ball tooltipped" data-position="bottom" data-delay="50" data-tooltip="随机数"></div>
                </div>
            </div>
            <!--土星 转盘-->
            <div class="orbit saturn" onclick="window.location='lottery/roll.jsp'">
                <div class="planet">
                    <div class="hoverable circle ball tooltipped" data-position="bottom" data-delay="50" data-tooltip="转盘"></div>
                </div>
            </div>
            <!--天王星 砸..砸金蛋？？-->
            <div class="orbit uranus" onclick="window.location='goldenegg.jsp'">
                <div class="planet">
                    <div class="hoverable circle ball tooltipped" data-position="bottom" data-delay="50" data-tooltip="砸金蛋"></div>
                </div>
            </div>
            <!--海王星-->
            <div class="orbit neptune">
                <div class="planet">
                    <div class="hoverable circle ball"></div>
                </div>
            </div>
            <!--冥王星-->
            <div class="orbit pluto">
                <div class="planet">
                    <div class="hoverable circle ball"></div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>