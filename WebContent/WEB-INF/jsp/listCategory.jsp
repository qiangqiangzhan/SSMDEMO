<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <table align="center" border="1" cellspacing="0">
       <tr>
          <td>id</td>
          <td>name</td>
       </tr>
       <c:forEach items="${list }" var="c" varStatus="st">
         <tr>
            <td>${c.id }</td>
            <td>${c.name }</td>
         </tr>
       </c:forEach> 
   </table>
   <div style="text-align:center">
        <a href="?start=0">首  页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <a href="?start=${page.start+page.count }">下一页</a>
        <a href="?start=${page.last}">末  页</a>
   </div> 
</body>
</html>