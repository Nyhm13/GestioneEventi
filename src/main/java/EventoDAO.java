import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
            System.out.println("Evento con id "+id_evento+" non trovato");
        }
    }
}
