package dao;

import entities.*;
import enumeration.Genere;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO() {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("postgres");
        em=emf.createEntityManager();
    }

    //metodo save che salva nel db l`evento passato come parametro

    public  void save(Evento evento){
        em.getTransaction().begin(); // inizia la transazione
        em.persist(evento);// salvo l`evento nel db
        em.getTransaction().commit();// confermo il salvataggio

    }
    // metodo per restituire un oggetto di tipo evento tramite la chiave primaria passata come parametro

    public Evento getById(int id_evento){
        return em.find(Evento.class,id_evento);
    }
    // metodo per rimuovere un evento dal db
    public void delete(int id_evento){
        Evento evento=getById(id_evento);
        if(evento!=null){
            em.getTransaction().begin();// inizio la transazione
            em.remove(evento);// rimuovo l`evento dal db se esiste
            em.getTransaction().commit();// confermo le nuove modifiche al db
        }else {
            System.out.println("entities.Evento con id "+id_evento+" non trovato");
        }
    }

    // metodo per chiudere la connessione al db
    public void close(){
        em.close();
    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming){
       TypedQuery<Concerto> query = em.createQuery("select c from Concerto c where c.inStreaming = :inStreaming", Concerto.class);
       query.setParameter("inStreaming", inStreaming);
       return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(Genere genere){
        TypedQuery<Concerto> query = em.createQuery("select c from Concerto c where c.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa(){
        TypedQuery<PartitaDiCalcio> query= em.createNamedQuery("getPartiteVinteInCasa", PartitaDiCalcio.class);
        return query.getResultList();
    }
    public List<PartitaDiCalcio> getPartiteVinteInTrasferta(){
        TypedQuery<PartitaDiCalcio> query= em.createNamedQuery("getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartitePareggiate(){
        TypedQuery<PartitaDiCalcio> query= em.createNamedQuery("getPartitePareggiate", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<GaraDiAtletica> getGaraDiAtleticaPerVincitore(Persona vincitore){
        TypedQuery<GaraDiAtletica> query= em.createQuery("select g from GaraDiAtletica g where g.vincitore= :vincitore", GaraDiAtletica.class);
        query.setParameter("vincitore", vincitore);
        return query.getResultList();
    }
    public List<GaraDiAtletica> getGaraDiAtleticaPerParecipante(Persona partecipante){
        TypedQuery<GaraDiAtletica> query= em.createQuery("select g from GaraDiAtletica g where :partecipante MEMBER OF g.atleti", GaraDiAtletica.class);
        query.setParameter("partecipante", partecipante);
        return query.getResultList();
    }

    public List<Evento> getSoldOut(){
        TypedQuery<GaraDiAtletica> query= em.createQuery("select g from GaraDiAtletica g where :partecipante MEMBER OF g.atleti", GaraDiAtletica.class);

        return query.getResultList();
    }


}
