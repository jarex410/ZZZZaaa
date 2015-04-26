<%@page import="Encje.Przedmiot"%>
<%@page import="Encje.Nauczyciel"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>First JSP</title>
</head>

<body>

	PO WALIDACJI
	<br />

	<jsp:useBean id="user" class="Encje.Uczen" scope="session"></jsp:useBean>

	<jsp:setProperty property="*" name="user" />

	<jsp:useBean id="check" class="MavenTest.starterDAO" scope="session"></jsp:useBean>


	<%
		if (check.check(user.getId(), user.getPass()) == 1) {
			out.print("<form method=\"post\" action=\"Przedmioty.jsp \">"
					+ "<input type=\"submit\" value=\"Wyświetl swoje przedmioty\">");
		}

		else if (check.check(user.getId(), user.getPass()) == 2) {

			String pom = "";
			String pom2 = "";
			int i = 0;
			Nauczyciel na = new Nauczyciel();
			na = check.subjectList(user.getId());

			java.util.List<Przedmiot> listaPrzemiotow = na.getPrzedmioty();
			Iterator<Przedmiot> it = listaPrzemiotow.iterator();

			while (it.hasNext())

			{

				pom += "<option>" + it.next().getNazwa()
						+ "</option>" + " ";

			}

			out.print("Wybierz przedmiot:  <form method=\"post\" action=\"Oceny.jsp \">"
					+ "<select name=\"Lista_zajec\"  size=\"5\">"
					+ pom
					+ " </select> "
					);

			out.print("Wybierz klase: "
					+ "<select name=\"Lista_klas\"  size=\"5\">"
					+ "<option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option>"
					+ " </select> "
					+ "<input type=\"submit\" value=\"Dodaj oceny dla wybranej klasy\"></form> ");


		}

		else
			out.print("Bład LOGOWANIA");
	%><br />
	<br />





</body>
</html>