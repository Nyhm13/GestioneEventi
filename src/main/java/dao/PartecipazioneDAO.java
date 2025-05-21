package dao;

import entities.Location;
import entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PartecipazioneDAO {
    private EntityManager em;

    public PartecipazioneDAO() {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("postgres");
        em=emf.createEntityManager();
    }

    //metodo save che salva nel db l`evento passato come parametro

    public  void save(Partecipazione partecipazione){
        em.getTransaction().begin(); // inizia la transazione
        em.persist(partecipazione);// salvo l`evento nel db
        em.getTransaction().commit();// confermo il salvataggio

    }
    // metodo per restituire un oggetto di tipo evento tramite la chiave primaria passata come parametro

    public Partecipazione getById(int id){
        return em.find(Partecipazione.class,id);
    }
    // metodo per rimuovere un evento dal db
    public void delete(int id){
        Partecipazione partecipazione=getById(id);
        if(partecipazione!=null){
            em.getTransaction().begin();// inizio la transazione
            em.remove(partecipazione);// rimuovo l`evento dal db se esiste
            em.getTransaction().commit();// confermo le nuove modifiche al db
        }else {
            System.out.println("Partecipazione con id "+id+" non trovato");
        }
    }

    // metodo per chiudere la connessione al db
    public void close(){
        em.close();
    }
}
