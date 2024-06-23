package pe.cibertec.examen.T2_Alejandro_Luyo.service;

import pe.cibertec.examen.T2_Alejandro_Luyo.model.dto.PersonajeDto;

import java.util.List;
import java.util.Optional;

public interface IPersonajeService {
    List<PersonajeDto> listarPersonajes();
    Optional<PersonajeDto> buscarPersonajePorId(Integer id);
    PersonajeDto registrarPersonaje(PersonajeDto personajeDTO);
    PersonajeDto modificarPersonaje(Integer id, PersonajeDto personajeDTO);
    void eliminarPersonajePorId(Integer id);
}
