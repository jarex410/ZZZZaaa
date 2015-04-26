<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>First JSP</title>
</head>

<body> 
	PRZEDMIOTY

	     <jsp:useBean id="user"
       class="Encje.User" scope="session"></jsp:useBean>
       
       <jsp:setProperty property="*" name="user" />

        <br />
             <jsp:useBean id="start"
       class="MavenTest.starterDAO" scope="session"></jsp:useBean>
       
 DANE:  <%=start.data(user) %><br/>

         <br />


         KUPA

</body>
</html>