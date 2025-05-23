package entities;

import enumeration.Genere;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "concerti")
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    private Genere genere;

}
