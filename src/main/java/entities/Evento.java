package entities;

import enumeration.tipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 30)
    private String nome;
    @Column(name = "data_evento")
    private LocalDate dataEvento;
    @Column(length = 200)
    private String descrizione;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private tipoEvento tipoEvento;
    @Column(name = "numero_massimo_partecipanti")
    private int numeroMassimoPartecipanti;
    @OneToOne // un evento ha una location
    @JoinColumn(name = "location_id")// collegamento tra la tabella eventi e la tabella location, chiave esterna chiamata location_id,
    // che si lega alla tabella location tramite la chiave primaria id della tabella location
    private Location location;
    @OneToMany(mappedBy = "evento")// un evento puo avere piu partecipazioni ma una partecipazione appartiene a un solo evento

    private List<Partecipazione> listaPartecipazioni;



    public Evento() {
    }

    public Evento( String nome, LocalDate dataEvento, String descrizione, tipoEvento tipoEvento, int numeroMassimoPartecipanti) {
//        this.id = id;
        this.nome = nome;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public tipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(tipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
        this.listaPartecipazioni = listaPartecipazioni;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "location=" + location +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", tipoEvento=" + tipoEvento +
                ", descrizione='" + descrizione + '\'' +
                ", dataEvento=" + dataEvento +
                ", nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
}
