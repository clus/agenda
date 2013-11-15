//********************************************//
//** Jesus Herencia, Clément Dautel - M1 MTI**//
//*******************************************//

import java.util.Date;
import java.util.*;

public class Evenement {

	private int codeEvenement;
	private Date date;
	private String nom;
	private String lieu;
	private Agenda agenda;

	//CONSTRUCTOR//
	public Evenement(int codeEvenement, Date date, String nom, String lieu, Agenda agenda){
		this.setCodeEvenement(codeEvenement);
		this.setDate(date);
		this.setNom(nom);
		this.setLieu(lieu);
		this.setAgenda(agenda);
	}

	//**************************************//
	//*              SETTERS              *//
	public void setCodeEvenement(int i) {
		this.codeEvenement = i;
	}

	public void setDate(Date d) {
		this.date = d;
	}

	public void setNom(String n) {
		this.nom = n;
	}

	public void setLieu(String l) {
		this.lieu = l;
	}

	public void setAgenda(Agenda a) {
		this.agenda = a;
	}


	//**************************************//
	//*              GETTERS              *//
	public int getCodeEvenement() {
		return this.codeEvenement;
	}

	public Date getDate() {
		return this.date;
	}

	public String getNom() {
		return this.nom;
	}

	public String getLieu() {
		return this.lieu;
	}

	public Agenda getAgenda() {
		return this.agenda;
	}



}