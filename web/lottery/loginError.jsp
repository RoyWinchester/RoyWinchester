<%--
  Created by IntelliJ IDEA.
  User: fankun
  Date: 2019/3/30
  Time: 6:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PlanetLottery</title>
    <link href="../css/register.css" rel="stylesheet" type="text/css">
</head>
<body>
    <%--<jsp:include page="head.jsp"/>--%>
    <div class="content">
        <div class="left">
            <div class="list_box">
                <div class="list_bk">
                    <%--<jsp:include page="menu.jsp"/>--%>
                </div>
            </div>
        </div>
        <div class="right">
            <div class="right_box">
                <div class="info_bk">
                    <div align="center">
                        <br><br>
                        <%
                            String st=request.getParameter("st");
                            if (st!=null){
                                if ("1".equals(st)){
                                    out.print("<div align=center><font color=blue>验证码码错误！请重新登录</font></div>");
                                }
                                else if("2".equals(st)){
                                    out.print("<div align=center><font color=blue>用户名或密码错误,请重新登录！</font></div>");
                                }
                                else if("3".equals(st)){
                                    out.print("<div align=center><font color=blue>"+session.getAttribute("userid")+" 欢迎您！</font></div>");
                                }
                                else{
                                    out.print("<div align=center><font color=blue>异常错误,请重新登录！</font></div>");
                                }
                            }
                            else{
                                out.print("<div align=center><font color=blue>异常错误,请重新登录！</font></div>");
                            }

                        %>
                        <br><br><br>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--<jsp:include page="foot.jsp"/>--%>
</body>
</html>