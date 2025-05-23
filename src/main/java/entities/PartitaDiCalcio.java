package entities;

import enumeration.tipoEvento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "partite_di_calcio")
@NamedQuery(name = "getPartiteVinteInCasa", query = "select p from PartitaDiCalcio p where p.goalCasa > p.goalTrasferta")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "select p from PartitaDiCalcio p where p.goalCasa < p.goalTrasferta")
@NamedQuery(name = "getPartitePareggiate", query = "select p from PartitaDiCalcio p where p.goalCasa = p.goalTrasferta")

public class PartitaDiCalcio extends Evento {
    @Column(name = "squadra_casa")
    private String squadraCasa;
    @Column(name = "squadra_ospite")
    private String squadraOspite;
    @Column(name = "squadra_vincente")
    private String squadraVincente;
    @Column(name = "gol_casa")
    private int golCasa;
    @Column(name = "squadra_trasferta")
    private int golTrasferta;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String nome, LocalDate dataEvento, String descrizione, tipoEvento tipoEvento, int numeroMassimoPartecipanti, String squadraCasa, String squadraOspite, String squadraVincente, int golCasa, int golTrasferta) {
        super(nome, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.golCasa = golCasa;
        this.golTrasferta = golTrasferta;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolCasa() {
        return golCasa;
    }

    public void setGolCasa(int golCasa) {
        this.golCasa = golCasa;
    }

    public int getGolTrasferta() {
        return golTrasferta;
    }

    public void setGolTrasferta(int golTrasferta) {
        this.golTrasferta = golTrasferta;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golCasa=" + golCasa +
                ", golTrasferta=" + golTrasferta +
                "} " + super.toString();
    }
}
