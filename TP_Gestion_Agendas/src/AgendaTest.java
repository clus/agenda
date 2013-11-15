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
	}
		
	@Test
	public void tester() {
		Agenda ag1 = new Agenda();
		ag.ajouterAgenda(ag1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			new Evenement(1,sdf.parse("01/01/2013"), "cours d'info","salle 237",ag1);
			new Evenement(2,sdf.parse("01/01/2013"), "cours de marketing","salle 230",ag1);
			new Evenement(3,sdf.parse("01/01/2013"), "cours de finance","salle 231",ag1);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		assertEquals(3, ag1.getListeEvenements().size());
		
	}

}
