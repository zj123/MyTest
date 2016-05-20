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
            Map<Integer, User> users = (Map<Integer, User>)request.getServletContext().getAttribute("users");
            Set<Integer> set = users.keySet();
            Iterator<Integer> it = set.iterator();
            while(it.hasNext()){
                Integer id =  it.next();
                User user = users.get(id);
               
        %>
   			<tr>
      			<td align="center"><%=user.getId() %></td>
				<td align="center"><%=user.getName() %></td>
				<td align="center">
					<input type="button" value="删除" onclick="document.location='userHandle?id='+<%=user.getId() %>"/>
				</td>
   		 	 </tr>
		<%
            }
        %>
    </table>
    <br>
    <br>
    <br>
    
    <form name="f1" method="post" action="userHandle" align="center" >
       id:<input name="id" type="text"><br><br>
       name:<input name="name" type="text"><br><br>
       <input type="submit" value="Submit" />
    </form>
</body>
</html>