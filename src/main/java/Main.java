import java.time.LocalDate;
import java.util.EventObject;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        EventoDAO eventoDAO= new EventoDAO();

        Evento evento1= new Evento(new Random().nextInt(1,1000),"Festa cado malato", LocalDate.of(2000,6,9),
                "Festa dove volano corde e sgabelli",tipoEvento.PUBBLICO,100000);
        try {
            eventoDAO.save(evento1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(eventoDAO.getById(evento1.getId()));
//        eventoDAO.delete(evento1.getId());

    }
}
