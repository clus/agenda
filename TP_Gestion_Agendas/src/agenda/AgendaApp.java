package agenda;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.UidGenerator;

public class AgendaApp {

	private ArrayList<Agenda> listeAgendas;
	private String url = "C:\\Users\\jesus\\Documents\\mycalendar.ics"; // remplir ici la direction de importation et exportation de fichier ics

	public AgendaApp(){
		this.listeAgendas = new ArrayList<Agenda>();
	}

	public void ajouterAgenda(Agenda a) {
		this.listeAgendas.add(a);
	}

	public ArrayList<Agenda> getListeAgendas() {
		return listeAgendas;
	}

	public void setListeAgendas(ArrayList<Agenda> listeAgendas) {
		this.listeAgendas = listeAgendas;
	}

	public void supprimerAgenda(Agenda a) {
		this.listeAgendas.remove(a);
	}

	public static void main(String[]args){
		//Creation d'agenda//
		AgendaApp ag = new AgendaApp();		//Creation d'une liste d'agendas
		Agenda ag1 = new Agenda();
		ag.ajouterAgenda(ag1);

	}
	
	public void exporter(){
		Calendar calendar = new Calendar();
		calendar.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
		calendar.getProperties().add(Version.VERSION_2_0);
		calendar.getProperties().add(CalScale.GREGORIAN);
		
		calendar.getComponents().addAll(getListeEvents());
		
		try{
			FileOutputStream fout = new FileOutputStream(this.url);
			CalendarOutputter outputter = new CalendarOutputter();
			outputter.output(calendar, fout);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void importer(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		try{
			FileInputStream fin = new FileInputStream(this.url);
			CalendarBuilder builder = new CalendarBuilder();
			Calendar calendar = builder.build(fin);
			System.out.println("Total:");
			for (Iterator i = calendar.getComponents().iterator(); i.hasNext();) {
				Component c = (Component) i.next();
			    System.out.println("Component [" + c.getName() + "]");
			    Evenement e = new Evenement(1, sdf.parse(c.getProperty(Property.DTSTART).getValue()), c.getProperty(Property.SUMMARY).getValue(), "");

			    for (Iterator j = c.getProperties().iterator(); j.hasNext();) {
			        Property property = (Property) j.next();
			        System.out.println("Property [" + property.getName() + ", " + property.getValue() + "]");
			    }
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private ArrayList<VEvent> getListeEvents(){
		ArrayList<VEvent> listEvents = new ArrayList<VEvent>();
		for(Agenda a : this.listeAgendas){
			for(Evenement e : a.getListeEvenements()){
				listEvents.add(convertEvenementToEvent(e));
			}
		}
		return listEvents;
	}
	
	private VEvent convertEvenementToEvent(Evenement e){	// convertir objet Evenement a VEvent
		VEvent v = new VEvent(new Date(e.getDate().getTime()), e.getNom());
		v.getProperties().add(new Description(e.getLieu()));
		try{
		UidGenerator uidGenerator = new UidGenerator("1");
		v.getProperties().add(uidGenerator.generateUid());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return v;
	}
}