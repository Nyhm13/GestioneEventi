package entities;

import enumeration.tipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name= "gare_di_atletica")
public class GaraDiAtletica extends  Evento{

    @ManyToMany
    @JoinTable(name = "gare_atleti",
    joinColumns = @JoinColumn(name = "gara_di_atletica_id"),
    inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private Set<Persona> atleti;


    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private  Persona vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String nome, LocalDate dataEvento, String descrizione, tipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        super(nome, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
