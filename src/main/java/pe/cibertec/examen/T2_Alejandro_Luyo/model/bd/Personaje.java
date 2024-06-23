package pe.cibertec.examen.T2_Alejandro_Luyo.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "personaje")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersonaje;
    private String nomPersonaje;
    private String apePersonaje;
    @Temporal(TemporalType.DATE)
    private Date fechNacPersonaje;
}
