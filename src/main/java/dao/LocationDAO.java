package dao;

import entities.Evento;
import entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LocationDAO {
    private EntityManager em;

    public LocationDAO() {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("postgres");
        em=emf.createEntityManager();
    }

    //metodo save che salva nel db l`evento passato come parametro

    public  void save(Location location){
        em.getTransaction().begin(); // inizia la transazione
        em.persist(location);// salvo l`evento nel db
        em.getTransaction().commit();// confermo il salvataggio

    }
    // metodo per restituire un oggetto di tipo evento tramite la chiave primaria passata come parametro

    public Location getById(int id){
        return em.find(Location.class,id);
    }
    // metodo per rimuovere un evento dal db
    public void delete(int id){
        Location location=getById(id);
        if(location!=null){
            em.getTransaction().begin();// inizio la transazione
            em.remove(location);// rimuovo l`evento dal db se esiste
            em.getTransaction().commit();// confermo le nuove modifiche al db
        }else {
            System.out.println("Location con id "+id+" non trovato");
        }
    }

    // metodo per chiudere la connessione al db
    public void close(){
        em.close();
    }
}
