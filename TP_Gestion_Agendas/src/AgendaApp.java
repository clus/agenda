import java.util.ArrayList;
import java.util.*;

public class AgendaApp {

	private ArrayList<Agenda> listeAgendas;


	public AgendaApp(){
		this.listeAgendas = new ArrayList<Agenda>();
	}

	public void ajouterAgenda(Agenda a) {
		this.listeAgendas.add(a);
	}

	public void supprimerAgenda(Agenda a) {
		this.listeAgendas.remove(a);
	}

	public static void main(String[]args){
		//Creation d'agenda//
		AgendaApp ag = new AgendaApp();		//Creation d'une liste d'agendas
		Agenda ag1 = new Agenda();
		ag.ajouterAgenda(ag1);
		
		//Creation d'evenements//
		Evenement ev1 = new Evenement(1,12/10/2013, "cours d'info","salle 237",ag1);
		
	}
}