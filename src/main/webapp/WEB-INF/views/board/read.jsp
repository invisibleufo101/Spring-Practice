<%--
  Created by IntelliJ IDEA.
  User: tonyha
  Date: 2024-10-07
  Time: 4:47 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read Page</title>
</head>
<body>
    <h1> Read Page</h1>
    <p>${ board }</p>
    <p>BNO:     ${ board.bno }    </p>
    <p>TITLE:   ${ board.title }  </p>
    <p>CONTENT: ${ board.content }</p>
    <p>WRITER:  ${ board.writer } </p>

</body>
</html>
