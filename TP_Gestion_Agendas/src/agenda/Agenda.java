package agenda;
import java.util.ArrayList;
import java.util.*;

public class Agenda {

	private String nom;
	private int codeAgenda;
	private ArrayList<Evenement> listeEvenements;



	//**************************************//
	//*              SETTER               *//


	public void setListeEvenements(ArrayList<Evenement> listeEvenements) {
		this.listeEvenements = listeEvenements;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setCodeAgenda(int i) {
		this.codeAgenda = i;
	}


	//**************************************//
	//*              GETTER               *//

	public String getNom() {
		return nom;
	}

	public ArrayList<Evenement> getListeEvenements() {
		return listeEvenements;
	}

	public int getCodeAgenda() {
		return this.codeAgenda;
	}


	//****************************************//
	//*              METHODS                *//

	public Agenda(){
		this.listeEvenements = new ArrayList<Evenement>();
	}

	public void ajouterEvenement(Evenement e){								//Permet d'ajouter un evenement à la liste d'évenements
		this.listeEvenements.add(e);
	}

	public void supprimerEvenement(Evenement e){							//Permet de supprimer un evenement à la liste d'évenements
		this.listeEvenements.remove(e);
	}


	public Evenement rechercherEvenement(int codeEvenement) {				//Permet de rechercher un evenement dans la liste d'évenements en fonction de son code

		for(Evenement e:this.listeEvenements){								//On parcours la liste d'evenements, 	
			if(e.getCodeEvenement()==codeEvenement)							//si le code rentré en parametre est egal au code d'un evenement de la liste, 
				return e;													//alors on retourne l'evenement recherché
		}
		return null;
	}

	public ArrayList<Evenement> filtrerEvenement(Evenement e) {				//On utilise un objet Evenement pour mettre les parametres de recherche des evenements

		ArrayList<Evenement> listeEvts = new ArrayList<Evenement>();		//Ici on crée une liste d'evenements
		boolean add_ev = true;
		for(Evenement ev:this.listeEvenements){								//Pour un evenement ev dans la liste d'evenements
			
			//			if(e.getAgenda()!=null && e.getAgenda().equals(ev.getAgenda())){
			//				listeEvts.add(ev);											
			//				continue;
			//			}
			add_ev = add_ev && compareAttributes(e.getNom(), ev.getNom());		//Si le nom de l'evenement recherché correspond au nom d'un evenement de la liste
			add_ev = add_ev && compareAttributes(e.getDate(), ev.getDate());	//Si la date de l'evenement recherché correspond à la date d'un evenement de la liste
			add_ev = add_ev && compareAttributes(e.getLieu(), ev.getLieu());	//Si le lieu de l'evenement recherché correspond au lieu d'un evenement de la liste
			if(add_ev){
				listeEvts.add(ev);	//On ajoute cet evenement a notre liste
			}
		}
		return listeEvts;

	}

	public void deplacerEvenement(Evenement e) {							//On recherche un evenement de la liste grace a son code

		for(Evenement ev:this.listeEvenements){
			if(e.getCodeEvenement()==ev.getCodeEvenement()){
				ev.setDate(e.getDate());									//et on lui attribue une nouvelle date
			}
		}

	}

	public boolean equals(Agenda a) {										//Car il existe un seul et unique code Agenda
		if(this.codeAgenda==a.codeAgenda)
			return true;
		return false;
	}


	public void modifierEvenements(ArrayList<Evenement> evs) {				//On recherche un evenement de la liste grace a son code

		for(Evenement ev1:this.listeEvenements){
			for(Evenement ev2:evs){
				if(ev1.getCodeEvenement()==ev2.getCodeEvenement()){
					ev1.setDate(ev2.getDate());								//On lui attribue une nouvelle date
					ev1.setNom(ev2.getNom());								//On lui attribue un nouveau nom
					ev1.setLieu(ev2.getLieu());								//On lui attribue un nouveau lieu
				}


			}

		}
	}
	
	private boolean compareAttributes(Object a, Object b){ // methode pour comparer 2 attributes des evenements
		if(a==null){
			return true;
		}
		else if(b==null){
			return false;
		}
		else if(a.equals(b)){
			return true;
		}
		else{
			return false;
		}
	}
}