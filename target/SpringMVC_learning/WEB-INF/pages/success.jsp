<%--
  Created by IntelliJ IDEA.
  User: mengmuzi
  Date: 2019-07-12
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored = "false"%>
<html>
<head>
    <title>TestSuccess</title>
</head>
<body>
<h1>success!!</h1>
request:${requestScope.requestParam}<br/>
session:${sessionScope.sessionParam}<br/>
pageContext:${pageScope.msg}<br/>
request:${requestScope.msg}<br/>
session:${sessionScope.msg}<br/>
application:${applicationScope.msg}<br/>
</body>
</html>
