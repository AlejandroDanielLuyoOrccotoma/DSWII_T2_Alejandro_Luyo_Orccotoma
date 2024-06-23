package pe.cibertec.examen.T2_Alejandro_Luyo.model.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PersonajeDto {
    private Integer idPersonaje;
    private String nomPersonaje;
    private String apePersonaje;
    private Date fechNacPersonaje;
}

