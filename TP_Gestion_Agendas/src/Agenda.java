import java.util.ArrayList;
import java.util.*;

public class Agenda {

	private int codeAgenda;
	private ArrayList<Evenement> listeEvenements;



	//**************************************//
	//*              SETTER               *//

	public void setCodeAgenda(int i) {
		this.codeAgenda = i;
	}


	//**************************************//
	//*              GETTER               *//

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

	public ArrayList<Evenement> filtrerEvement(Evenement e) {

		ArrayList<Evenement> listeEvts = new ArrayList<Evenement>();

		for(Evenement ev:this.listeEvenements){

			if(e.getNom()!=null && e.getNom().equals(ev.getNom())){
				listeEvts.add(ev);
				continue;
			}
			if(e.getDate()!=null && e.getDate().equals(ev.getDate())){
				listeEvts.add(ev);
				continue;}
			if(e.getLieu()!=null && e.getLieu().equals(ev.getLieu())){
				listeEvts.add(ev);
				continue;
			}
			if(e.getAgenda()!=null && e.getAgenda().equals(ev.getAgenda())){
				listeEvts.add(ev);
				continue;
			}
		}
		return listeEvts;

	}

	public void deplacerEvement(Evenement e) {

		for(Evenement ev:this.listeEvenements){
			if(e.getCodeEvenement()==ev.getCodeEvenement()){
				ev.setDate(e.getDate());
			}
		}

	}


	public void modifierEvenements(ArrayList<Evenement> evs) {

		for(Evenement ev1:this.listeEvenements){
			for(Evenement ev2:evs){
				if(ev1.getCodeEvenement()==ev2.getCodeEvenement()){
					ev1.setDate(ev2.getDate());
					ev1.setNom(ev2.getNom());
					ev1.setLieu(ev2.getLieu());
				}


			}

		}
	}
}