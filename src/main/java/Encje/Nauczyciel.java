package Encje;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import Encje.Przedmiot;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Nauczyciel {

	@Id
	private long id;
	private String imie;	
	private String nazwisko;
	private String adres;
	private String pass;

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@OneToMany
    @JoinColumn(name = "Prowadzacy")
	private List<Przedmiot> przedmioty;

	public long getId() {
		return id;
	}

	public void setId_nauczyciela(long id) {
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

	public List<Przedmiot> getPrzedmioty() {
		return przedmioty;
	}

	public void setPrzedmioty(List<Przedmiot> przedmioty) {
		this.przedmioty = przedmioty;
	}

}
