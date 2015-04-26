package Encje;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Uczen {

	@Id
	private long id;
	private String imie;
	private String nazwisko;
	private String adres;
	private String klasa;
	private String pass;
	
//	@OneToOne(cascade = {CascadeType.ALL})
	//private User user;

	
	@ManyToMany(mappedBy = "uczniowie")
	private List<Przedmiot> przedmioty;

	@OneToMany
  //  @JoinColumn (name = "ID UCZNIA")
	private List<Ocena> oceny;
	


	public Uczen() {

	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Uczen(String imie, String nazwisko, String adres,
			String klasa) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.adres = adres;
		this.klasa = klasa;
	}

	public List<Przedmiot> getPrzedmioty() {
		return przedmioty;
	}

	public void setPrzedmioty(List<Przedmiot> przedmioty) {
		this.przedmioty = przedmioty;
	}


	public List<Ocena> getOceny() {
		return oceny;
	}

	public void setOceny(List<Ocena> oceny) {
		this.oceny = oceny;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getKlasa() {
		return klasa;
	}

	public void setKlasa(String klasa) {
		this.klasa = klasa;
	}

}
