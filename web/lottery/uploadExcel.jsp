<%--
  Created by IntelliJ IDEA.
  User: fankun
  Date: 2019/3/31
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>POIExcel</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <script type="text/javascript" src="../jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="../jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4.1/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4.1/themes/icon.css">

    <script type="text/javascript">
        $(function(){
            Init();//打开页面就去查询了
        });
        //我去查询所有用户信息了
        function Init(){
            $('#excel').datagrid({
                type : 'post',
                url : '../servlet/CandidateJsonServlet',
                loadMsg : '数据加载中,请稍等!!!!!!!!',
                nowrap : false,
                striped : true,
                fit : true,
                pagination:true,
                columns : [[
                    {field:'checkbox',checkbox:true},
                    {field : 'candidateid',title : '编号',width : 100,align:'center'},
                    {field : 'candidatename',title : '姓名',width : 120,align:'center'}
                ]],
                toolbar: [{
                    width:'50',
                    iconCls: 'icon-undo',
                    handler: function(){ExcelImport();}
                },'-',{
                    width:'50',
                    iconCls: 'icon-redo',
                    handler: function(){ExcelExport();}
                }]
            });
        }
        /*Excel导入  */
        function ExcelImport() {
            alert("导入excel!")
            var url="../servlet/ExcelImportServlet";
            window.location.href=url;
            //window.open(url);
        }
        /*Excel导出  */
        function ExcelExport(){
            alert("导出excel!")
            var url="../servlet/ExcelExportServlet";
            window.open(url);
        }
    </script>
    <style>
        html,
        body {
            background: url("../images/demo-1-bg.jpg") ;
        }
    </style>
</head>

<body>
<div align="center">
    <div class="easyui-panel" title="Excel导入导出示例"
         style="width: 930px; height: 350px; background: #fafafa;"
         data-options="border:false">
        <table id="excel"></table>
    </div>
</div>
</body>
</html>
