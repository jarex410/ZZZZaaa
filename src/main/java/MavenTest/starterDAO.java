package MavenTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Encje.Nauczyciel;
import Encje.Ocena;
import Encje.Przedmiot;
import Encje.Uczen;
import Encje.User;

public class starterDAO {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public starterDAO() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("manager");
		entityManager = entityManagerFactory.createEntityManager();
	}

	public String start() {

		/*
		 * 
		 * Uczen uczen = new Uczen(); Uczen uczen1=new
		 * Uczen("Janek","Nowak","Janowa 13","5");
		 * 
		 * Nauczyciel nauczyciel = new Nauczyciel();
		 * 
		 * Przedmiot przedmiot = new Przedmiot(); Przedmiot przedmiot1 = new
		 * Przedmiot();
		 * 
		 * Ocena ocena = new Ocena(); Ocena ocena1 = new Ocena();
		 * 
		 * List<Przedmiot> przedmioty = new ArrayList<Przedmiot>(); List<Uczen>
		 * uczniowie = new ArrayList<Uczen>(); List<Ocena> oceny = new
		 * ArrayList<Ocena>();
		 * 
		 * uczen.setAdres("Korchów Pierwszy 155"); uczen.setImie("Jaros³aw");
		 * uczen.setNazwisko("Padjasek"); uczen.setKlasa("IIIa");
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * przedmiot1.setNazwa("Matematyka");
		 * 
		 * 
		 * 
		 * przedmiot.setNazwa("Infa");
		 * 
		 * 
		 * 
		 * 
		 * przedmioty.add(przedmiot1); przedmioty.add(przedmiot);
		 * 
		 * 
		 * uczniowie.add(uczen); uczniowie.add(uczen1);
		 * 
		 * 
		 * 
		 * 
		 * nauczyciel.setImie("Jan"); nauczyciel.setNazwisko("Nowak");
		 * nauczyciel.setAdres("Rzeszow konopnicka 13");
		 * 
		 * ocena.setOceny("5 4 3"); ocena1.setOceny("0 0 0");
		 * 
		 * oceny.add(ocena); oceny.add(ocena1);
		 * 
		 * 
		 * uczen.setOceny(oceny); przedmiot1.setUczniowie(uczniowie);
		 * przedmiot.setUczniowie(uczniowie); przedmiot1.setOceny(oceny);
		 * nauczyciel.setPrzedmioty(przedmioty);
		 * uczen1.setPrzedmioty(przedmioty); uczen.setPrzedmioty(przedmioty);
		 * 
		 * 
		 * 
		 * 
		 * entityManager.getTransaction().begin(); entityManager.persist(ocena);
		 * entityManager.persist(ocena1); entityManager.persist(uczen);
		 * entityManager.persist(uczen1); entityManager.persist(przedmiot);
		 * entityManager.persist(przedmiot1); entityManager.persist(nauczyciel);
		 * 
		 * 
		 * 
		 * entityManager.getTransaction().commit();
		 */

		// entityManager.close();
		// entityManagerFactory.close();
		return "POSZLO";
	}

	public int check(long id, String pass) {

		if (entityManager
				.createQuery(
						"SELECT u FROM Uczen u WHERE u.id LIKE :id AND u.pass LIKE :pass")
				.setParameter("id", id).setParameter("pass", pass)
				.getResultList().isEmpty() == false)
			return 1; // jesli jest uczniem
		else if (entityManager
				.createQuery(
						"SELECT n FROM Nauczyciel n WHERE n.id LIKE :id AND n.pass LIKE :pass")
				.setParameter("id", id).setParameter("pass", pass)
				.getResultList().isEmpty() == false)
			return 2; // jesli jest nauczycielem
		else
			return 0; // 0 jesli user nie istnieje
	}

	@SuppressWarnings("unchecked")
	public Nauczyciel subjectList(long id_nauczyciela) {
		Nauczyciel na = new Nauczyciel();
		List<Nauczyciel> listaPrzedmiotow;

		listaPrzedmiotow = entityManager
				.createQuery("SELECT n FROM Nauczyciel n WHERE n.id LIKE :id")
				.setParameter("id", id_nauczyciela).getResultList();
		na = listaPrzedmiotow.get(0);

		return na;
	}

	@SuppressWarnings("unchecked")
	public List<Uczen> getClassStudentList(String klasa) {

		List<Encje.Uczen> listaUczniow = entityManager
				.createQuery("SELECT u FROM Uczen u WHERE u.klasa LIKE :klasa")
				.setParameter("klasa", klasa).getResultList();

		return listaUczniow;
	}

	public int findSubId(String name) {
		Integer id = null;

		@SuppressWarnings("unchecked")
		List<Przedmiot> listaPrzemiotow = entityManager
				.createQuery(
						"SELECT p FROM Przedmiot p WHERE p.nazwa LIKE :przedmiot")
				.setParameter("przedmiot", name).getResultList();
		id = listaPrzemiotow.get(0).getId();

		return id;
	}

	public String upDate(String lista_uczniow, String lista_ocen, int id) {
		ArrayList<Uczen> listaUczniow = new ArrayList<Uczen>();
		ArrayList<Ocena> listaOcen = new ArrayList<Ocena>();

		String Dane[] = null;
		String Oceny[] = null;
		String Pom[] = null;
		Uczen ucz = new Uczen();

		@SuppressWarnings("unchecked")
		List<Przedmiot> listaPrzemiotow = entityManager
				.createQuery("SELECT p FROM Przedmiot p WHERE p.id LIKE :id")
				.setParameter("id", id).getResultList();
		Przedmiot przedmiot1 = listaPrzemiotow.get(0); // Wybrany przedmiot
		Dane = lista_uczniow.split("\n");
		Oceny = lista_ocen.split("\n");
		String POM = "";

		Iterator<Uczen> it = listaUczniow.iterator();

		for (int i = 0; i < Dane.length; i++) {
			Pom = Dane[i].split(" ", 2);
			// POM += " Imie  " + Pom[0];
			ucz.setImie(Pom[0]);
			// POM += " Nazw " + Pom[1];
			ucz.setNazwisko(Pom[1]);
			listaUczniow.add(ucz);
			Pom = null;
		}

		String pom3 = "";

		// entityManager.getTransaction().begin();

		for (int k = 0; k < Oceny.length; k++) {
			Ocena oc = new Ocena();
			oc.setOceny(Oceny[k]); //

			entityManager.getTransaction().begin();
			entityManager.persist(oc);
			// entityManager.flush();
			entityManager.getTransaction().commit();
			listaOcen.add(oc);

			przedmiot1.setOceny(listaOcen);

			// entityManager.flush();

		} 
		entityManager.getTransaction().begin();
		entityManager.persist(przedmiot1);
		entityManager.getTransaction().commit();

		
		
		for (int jj = 0; jj <listaUczniow.size(); jj++) { //Dodawanie ocen uczniom
			Uczen uczen = new Uczen();
			Ocena oc = new Ocena();
			List<Ocena> listaOcenPom = new ArrayList<Ocena>();
		//	oc=listaOcen.get(jj);
			
			//listaOcenPom.add(listaOcen.get(jj));
			uczen = listaUczniow.get(jj);
			pom3=listaUczniow.get(1) + "ROZMIAR  JJ ="+jj;
		//	uczen.setOceny(listaOcenPom);
		//	entityManager.getTransaction().begin();
		//	entityManager.persist(uczen);
		//	entityManager.getTransaction().commit();
		}
		
		return pom3;

	}

	/*
	 * @SuppressWarnings("unchecked") public String data(User user) { starterDAO
	 * st = new starterDAO(); if(st.check(user.getLogin(),
	 * user.getPass())==true) { List<Uczen> lista; User user2; String pom="";
	 * lista=entityManager.createQuery("SELECT  u FROM  Uczen u")
	 * .getResultList(); for(Uczen ucz: lista) { user2=ucz.getUser();
	 * pom+=" used2 log  "+user2.getLogin();
	 * if(user2.getLogin().compareTo(user.getLogin())==1) { return "Imie : "
	 * +ucz.getImie() + " Nazwisko : " + ucz.getNazwisko(); } }
	 * 
	 * return pom+" us log" +user.getLogin(); } else return "GOWNO";
	 * 
	 * }
	 */

	@SuppressWarnings("unchecked")
	public String findSubject(Uczen uczen) {
		List<Przedmiot> lista;
		lista = entityManager
				.createQuery(
						"SELECT  p FROM  Przedmiot p WHERE p.uczniowie LIKE :uczen")
				.setParameter("uczen", uczen).getResultList();

		return lista.toString();
	}

	public String find(String login, String pass)

	{

		User user;
		// entityManager.getTransaction().begin();

		String query = "SELECT User FROM User";

		// query1.setParameter(1, login);
		// query1.setParameter(2, pass);
		// entityManager.createQuery(query);

		Integer pom = -1;

		pom = entityManager.createQuery(query).getFirstResult();

		return pom.toString();

		// entityManager.getTransaction().commit();

	}

	public boolean rejestracja(boolean adm, String login, String pass) {

		User user = new User();

		user.setAdm(adm);
		user.setLogin(login);
		user.setPass(pass);

		entityManager.getTransaction().begin();

		entityManager.persist(user);

		entityManager.getTransaction().commit();

		return true;
	}

}
