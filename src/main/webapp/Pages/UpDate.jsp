<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="start" class="MavenTest.starterDAO" scope="session"></jsp:useBean>
	<jsp:useBean id="pom2" class="MavenTest.pom" scope="session" />
UPDATE::

	<%
		int id;
	
		String listaUczniow= request.getParameter("Lista_Uczniow");
		String listaOcen = request.getParameter("Lista_Ocen");
		String Przedmiot =pom2.getPrzedmiot() ;
		String Klasa = pom2.getKlasa();
		
		
		id=start.findSubId(Przedmiot);

		out.print(start.upDate(listaUczniow, listaOcen, id));
	
		
	%>
	
	DODANE:

</body>
</html>