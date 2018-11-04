<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
     <tr>
        <th>账号</th>
        <th>姓名</th>
        <th>密码</th>
     </tr>
     <c:forEach items="${adminlist}" var="a">
     <tr>
        <td>${a.a_id}</td>
        <td>${a.a_pwd}</td>
        <td>${a.a_name}</td>
        <td>
          <a href="UserUpdateServlet?umobile=${u.umobile }&flag=delete">删除</a>
          <a href="UserUpdateServlet?umobile=${u.umobile }&flag=update">修改</a>
        </td>
     </tr>
     </c:forEach>
  </table>
</body>
</html>