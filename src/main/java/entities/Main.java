package entities;

import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import enumeration.Sesso;
import enumeration.Stato;
import enumeration.tipoEvento;

import java.time.LocalDate;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        EventoDAO eventoDAO=new EventoDAO();
        PersonaDAO personaDAO= new PersonaDAO();
        PartecipazioneDAO partecipazioneDAO= new PartecipazioneDAO();
        LocationDAO locationDAO= new LocationDAO();

//        Evento e1= new Evento("fiera",LocalDate.of(2000,1,1),"fiera di Roma",
//                tipoEvento.PUBBLICO,100);
//
//        Evento e2= new Evento("concerto",LocalDate.of(2020,1,12),"concerto di roma",
//                tipoEvento.PUBBLICO,100);
//
//        eventoDAO.save(e1);
//        eventoDAO.save(e2);



        Location l1= new Location("Fiera rho","Milano");
        Location l2= new Location("Piazza del popolo","Roma");

        locationDAO.save(l1);
        locationDAO.save(l2);

//        e1.setLocation(l1);
//        e2.setLocation(l2);
//
//        eventoDAO.save(e1);
//        eventoDAO.save(e2);


        Persona p1= new Persona( "Marco","Rossi",LocalDate.of(2000,1,1),"cadomalato", Sesso.M);
        Persona p2= new Persona( "Francesca","Bianchi",LocalDate.of(2020,1,21),"cadomalatomolto", Sesso.F);

        personaDAO.save(p1);
        personaDAO.save(p2);

        Partecipazione part1 = new Partecipazione(Stato.CONFERMATA);
        Partecipazione part2 = new Partecipazione(Stato.CONFERMATA);

        partecipazioneDAO.save(part1);
        partecipazioneDAO.save(part2);

//        part1.setEvento(e1);
//        part2.setEvento(e2);
        part1.setPersona(p1);
        part2.setPersona(p2);

        partecipazioneDAO.save(part1);
        partecipazioneDAO.save(part2);



    }
}
