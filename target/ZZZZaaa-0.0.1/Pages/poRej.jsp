<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>First JSP</title>
</head>

<body> 

PO REJESTRACJI

    <jsp:useBean id="user" class="Encje.User"
        scope="session"></jsp:useBean>
        
        <jsp:setProperty property="*" name="user" />

     <jsp:useBean id="rejestruj"
       class="MavenTest.starterDAO" scope="session"></jsp:useBean>

Po REJ

         Wynik: <%= rejestruj.rejestracja(user.isAdm(),user.getLogin() , user.getPass()) %>
         <br />


         KUPA

</body>
</html>