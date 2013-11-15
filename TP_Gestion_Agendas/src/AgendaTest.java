import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;


public class AgendaTest {

	private AgendaApp ag;

	@Before
	public void init(){

		ag = new AgendaApp();	
		Agenda ag1 = new Agenda();

		ag.ajouterAgenda(ag1);

		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

		try {
			Evenement ev1 = new Evenement(1,sdf.parse("12/10/2013"), "cours d'info","salle 237",ag1);
			Evenement ev2 = new Evenement(2,sdf.parse("12/10/2013"), "cours de marketing","salle 230",ag1);
			Evenement ev3 = new Evenement(3,sdf.parse("12/10/2013"), "cours de finance","salle 231",ag1);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testerRechercherEvenement() {
		Evenement ev1=null;
		Agenda ag1 = this.ag.getListeAgendas().get(0);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

		try {
			ev1 = new Evenement(1,sdf.parse("12/10/2013"), "cours d'info","salle 237");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		assertEquals(true, ag1.rechercherEvenement(1).equals(ev1));
	}
	
	@Test
	public void testerFiltrerEvenement() {
		
		Evenement ev1=null;
		Agenda ag1 = this.ag.getListeAgendas().get(0);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

		try {
			ev1 = new Evenement(0,sdf.parse("12/10/2013"), "cours d'info","salle 237");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		assertEquals(1, ag1.filtrerEvenement(ev1).size());
	}
}
