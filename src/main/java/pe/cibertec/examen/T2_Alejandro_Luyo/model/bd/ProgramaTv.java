package pe.cibertec.examen.T2_Alejandro_Luyo.model.bd;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Getter
@Setter
@Entity
@Table(name = "ProgramaTv")
public class ProgramaTv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProgramaTv")
    private Integer idProgramaTv;

    @Column(name = "Titulo", nullable = false, length = 250)
    private String titulo;

    @Column(name = "Resumen", nullable = false, length = 250)
    private String resumen;

    @Column(name = "FechaInicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @ManyToOne
    @JoinColumn(name = "IdPersonaje", nullable = false)
    private Personaje personaje;
}
