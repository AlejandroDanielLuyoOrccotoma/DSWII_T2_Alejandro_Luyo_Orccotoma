package pe.cibertec.examen.T2_Alejandro_Luyo.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "programatv")
public class ProgramaTv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProgramaTv;
    private String titulo;
    private String resumen;
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @ManyToOne
    private Personaje personaje;
}
