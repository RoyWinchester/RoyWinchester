<%--
  Created by IntelliJ IDEA.
  User: fankun
  Date: 2019/4/21
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册错误</title>
    <link href="css/shop.css" rel="stylesheet" type="text/css">
</head>
<body>
<%--<jsp:include page="head.jsp"/>--%>
<div class="content">
    <div class="right">
        <div class="right_box">
            <div class="info_bk">
                <div align="center">
                    <br><br>
                    <%
                        String st=request.getParameter("st");
                        if (st!=null){
                            if ("1".equals(st)){
                                out.print("<div align=center><font color=blue>用户名已存在</font></div>");
                            }
                            else if("2".equals(st)){
                                out.print("<div align=center><font color=blue>ע���쳣,������ע�ᣡ</font></div>");

                            }
                            else if("0".equals(st)){
                                out.print("<div align=center><font color=blue>ע���쳣,������ע�ᣡ</font></div>");

                            }
                            else{
                                out.print("<div align=center><font color=blue>ע��ɹ���</font></div>");
                            }
                        }
                        else{
                            out.print("<div align=center><font color=blue>�쳣����������ע�ᣡ</font></div>");
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

