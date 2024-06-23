package pe.cibertec.examen.T2_Alejandro_Luyo.model.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ProgramaTvDto {
    private Integer idProgramaTv;
    private String titulo;
    private String resumen;
    private Date fechaInicio;
    private Integer idPersonaje;
}

