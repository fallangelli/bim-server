<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
  <!--[if gt IE 8]>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <![endif]-->

  <title>哔哔电影</title>

  <link rel="icon" type="/image/ico" href="${ctx}/img/favicon.png"/>

  <link href="${ctx}/css/stylesheets.css" rel="stylesheet" type="text/css"/>
  <!--[if lt IE 8]>
  <link href="${ctx}/css/ie7.css" rel="stylesheet" type="text/css"/>
  <![endif]-->
  <link rel='stylesheet' type='text/css' href='${ctx}/css/fullcalendar.print.css' media='print'/>


</head>
<body>

<div class="errorPage">
  <p class="name">403</p>

  <p class="description">禁止访问，请登录后重试</p>

  <p>
    <button class="btn btn-danger" onClick="document.location.href = '${ctx}/login';">登录系统</button>
    <button class="btn btn-warning" onClick="history.back();">返回上一页</button>
  </p>
</div>

</body>
</html>

</SCRIPT>
