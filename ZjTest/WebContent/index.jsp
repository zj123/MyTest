<%@ page import="java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.zj.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>

	<table align="center" border="1" bordercolor="FFDC75" cellpadding="3" cellspacing="3">
	   	<tr>
	       	<th>id</th>
	       	<th>name</th>
	       	<th>功能</th>
	    </tr>
	    
	    
        <%
            List<User> users = (List<User>)request.getSession().getAttribute("users");
            for (User user:users) {
        %>
        	<form name="f1" method="post" action="orderinfo">
	   			<tr>
	      			<td align="center"><%=user.getId() %></td>
					<td align="center"><%=user.getId() %></td>
					<td align="center">
						<input type="button" value="删除" onclick="document.location='delUser?id='+<%=user.getId() %>"/>
					</td>
	   		 	</tr>
			</form>
		<%
            }
        %>
        
	    
	  <%--  	<c:forEach var="user" items="${users}"> 
			<form name="f1" method="post" action="orderinfo">
	   			<tr>
	      			<td align="center">${user.key}</td>
					<td align="center">${user.value.name}</td>
					<td align="center">
						<input type="button" value="删除" onclick="document.location='delUser?id='+${user.key}"/>
					</td>
	   		 	</tr>
			</form>
		</c:forEach> --%>
	</table>
</body>
</html>