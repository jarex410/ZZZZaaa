package Encje;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ocena {
	

	@Id
	@GeneratedValue
	private int id_ocen;
	private String oceny;
	
	
	public int getId_ocen() {
		return id_ocen;
	}
	public void setId_ocen(int id_ocen) {
		this.id_ocen = id_ocen;
	}
	public String getOceny() {
		return oceny;
	}
	public void setOceny(String oceny) {
		this.oceny = oceny;
	}

}
