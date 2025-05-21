package dao;

import entities.Partecipazione;
import entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonaDAO {
    private EntityManager em;

    public PersonaDAO() {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("postgres");
        em=emf.createEntityManager();
    }

    //metodo save che salva nel db l`evento passato come parametro

    public  void save(Persona persona){
        em.getTransaction().begin(); // inizia la transazione
        em.persist(persona);// salvo l`evento nel db
        em.getTransaction().commit();// confermo il salvataggio

    }
    // metodo per restituire un oggetto di tipo evento tramite la chiave primaria passata come parametro

    public Persona getById(int id){
        return em.find(Persona.class,id);
    }
    // metodo per rimuovere un evento dal db
    public void delete(int id){
        Persona persona=getById(id);
        if(persona!=null){
            em.getTransaction().begin();// inizio la transazione
            em.remove(persona);// rimuovo l`evento dal db se esiste
            em.getTransaction().commit();// confermo le nuove modifiche al db
        }else {
            System.out.println("persona con id "+id+" non trovato");
        }
    }

    // metodo per chiudere la connessione al db
    public void close(){
        em.close();
    }
}
