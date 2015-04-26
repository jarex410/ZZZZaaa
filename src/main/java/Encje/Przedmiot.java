package Encje;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Przedmiot {

	@Id
	@GeneratedValue
	private int id;
	private String nazwa;

	@ManyToMany
	@JoinColumn(name = " Uczniowie")
	private List<Uczen> uczniowie;
	@OneToMany
	// @JoinColumn (name = "ID OCENY")
	private List<Ocena> oceny;

	public List<Ocena> getOceny() {
		return oceny;
	}

	public void setOceny(List<Ocena> oceny) {
		this.oceny = oceny;
	}

	public List<Uczen> getUczniowie() {
		return uczniowie;
	}

	public void setUczniowie(List<Uczen> uczniowie) {
		this.uczniowie = uczniowie;
	}

	/*
	 * public List<Ocena> getOceny() { return oceny; }
	 * 
	 * public void setOceny(List<Ocena> oceny) { this.oceny = oceny; }
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

}
