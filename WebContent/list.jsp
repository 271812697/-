<%@ page import="java.util.*" %>
<%@ page import="userinfo.user" %>
<%@ page import="userinfo.getalluser" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script >
    
    window.onload=function(){
    	var btn=document.getElementById("btn");
    	btn.onclick=function(){
    		
    		
    		var fid=document.getElementById("fid");
    		fid.submit();
    		
    	}
    	
    	
    }
    </script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<%
   String flag=(String)request.getAttribute("choose");
   if(flag==null || flag.equals("false")){
	   
	   List<user> a=getalluser.get();
	    request.setAttribute("list", a);
	    request.getSession().setAttribute("num", getalluser.getid());
	   
	   
   }
   else{
	   
	   
	  request.setAttribute("choose", "false");
   }
    
  %>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float:left;">
    <form class="form-inline" action="selectquery" method="post">
  <div class="form-group">
    <label for="exampleInputName1">姓名</label>
    <input type="text" class="form-control" id="exampleInputName1" name="na">
  </div>
  <div class="form-group">
    <label for="exampleInputName2">籍贯</label>
    <input type="text" class="form-control" id="exampleInputName2" name="city">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail3">邮箱</label>
    <input type="email" class="form-control" id="exampleInputEmail3" name="em">
  </div>
  <button type="submit" class="btn btn-default">查询</button>
</form>
    </div>
    <div style="float:right;margin:5px;">
    
            <a class="btn btn-primary" href="add.html">添加联系人</a>
            <a class="btn btn-primary" href="javascript:void(0);" id="btn">删除选中</a>
    
    </div>
   <form action="del" method="post" id="fid">
   
   
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox"/></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${list}" var="temp">
        <tr>
         <td><input type="checkbox" value="${temp.id}" name="uid"/></td>
        <td>
        ${temp.id}
        </td>
        <td>${temp.name}</td>
        <td>${temp.gender}</td>
        <td>${temp.age}</td>
        <td>${temp.address}</td>
        <td>${temp.qq}</td>
        <td>${temp.emial}</td>
         <td><a class="btn btn-default btn-sm" href="update.html?row=${temp.id}">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="delete?row=${temp.id}">删除</a></td>
        </tr>
        </c:forEach>
    </table>
   
   
   
   
   </form>
   
   
   
   
    <div>
    
    <nav aria-label="Page navigation">
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    <span style="font-size:25px;margin-left:25px;">
    共16页,64条记录
    </span>
  </ul>
</nav>
    </div>
</div>
</body>
</html>